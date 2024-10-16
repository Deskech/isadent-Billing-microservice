package com.microservice.factura.Infraestructure.Services;

import com.microservice.factura.Application.Dtos.NewPaymentRequest;
import com.microservice.factura.Domain.Events.Published.PaymentPublished;
import com.microservice.factura.Domain.Factories.FactoryBillValues;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Domain.Models.Query.QueryBillValues;
import com.microservice.factura.Domain.Repository.CommandLine.BillValuesRepository;
import com.microservice.factura.Domain.Repository.Query.QueryBillValuesRepository;
import com.microservice.factura.Domain.Services.NewPayment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the new payment domain service implementation.
 */
@Component
public class NewPaymentImpl implements NewPayment<NewPaymentRequest> {

    private final QueryBillValuesRepository queryBillValuesRepository;
    private final BillValuesRepository billValuesRepository;
    private final PaymentPublished<BillValues> paymentPublished;
    private final FactoryBillValues factoryBillValues;

    public NewPaymentImpl(QueryBillValuesRepository queryBillValuesRepository, BillValuesRepository billValuesRepository,
                          PaymentPublished<BillValues> paymentPublished, FactoryBillValues factoryBillValues
    ) {

        this.queryBillValuesRepository = queryBillValuesRepository;
        this.billValuesRepository = billValuesRepository;
        this.paymentPublished = paymentPublished;
        this.factoryBillValues = factoryBillValues;

    }

    /**
     * this service is used when a new payment is set and the patient's bill monetary values needs to be updated.
     * this service assumes the patients has previous payments
     * @param newPayment represents the new payment the patient has done
     */
    @Transactional
    @Override
    public void alternatePayment(NewPaymentRequest newPayment) {
        try {
            //we get total, restante and payment from the CUD DB.
            QueryBillValues valoresAntiguaFactura = queryBillValuesRepository.getRestanteAndAbono(newPayment.getPatientName());
            /*Then the Bill values factory is used to create a new instance of
            * Bill vales that represents the patient's bill monetary values */
            BillValues billValues = factoryBillValues.createBillValues(valoresAntiguaFactura, newPayment);
            //we use the domain repository interface to update the patient's bill monetary values (billValues).
            billValuesRepository.updateBillValues(billValues, newPayment.getPatientName());
            //We publish the event so that the Query line database can update the data.
            paymentPublished.reportEvent(billValues, newPayment.getPatientName());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
