package com.microservice.factura.Infraestructure.Services;

import com.microservice.factura.Application.Dtos.NewQuotationMessage;
import com.microservice.factura.Domain.Events.Publicados.QuotationPublished;
import com.microservice.factura.Domain.Factories.FactoryBillValues;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Domain.Repository.CommandLine.BillValuesRepository;
import com.microservice.factura.Domain.Repository.CommandLine.WriteBillRepository;
import com.microservice.factura.Domain.Services.NewQuotation;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the New Quotation domain service implementation.
 */
@Component
public class NewQuotationImpl implements NewQuotation<NewQuotationMessage> {

    private  final BillValuesRepository billValuesRepository;
    private final WriteBillRepository writeBillRepository;
    private final FactoryBillValues factoryBillValues;
    private final QuotationPublished<BillValues, NewQuotationMessage> quotationPublished;

    public NewQuotationImpl(BillValuesRepository billValuesRepository,
                            WriteBillRepository writeBillRepository, FactoryBillValues factoryBillValues,
                            QuotationPublished<BillValues, NewQuotationMessage> quotationPublished
                             ) {

        this.billValuesRepository = billValuesRepository;
        this.writeBillRepository = writeBillRepository;
        this.factoryBillValues = factoryBillValues;
        this.quotationPublished = quotationPublished;
    }

    /**
     *
     * @param newQuotation this is an object that is listened from the Quotation microservice
     */
    @Transactional
    @Override
    public void saveNewQuotation(NewQuotationMessage newQuotation) {
        try {
            //we use the factory interface to create a new instance of our aggregate.
            BillValues billValues = factoryBillValues.billValuesFirsTime(newQuotation);
            //we use our Domain repository interfaces for data persistence.
            billValuesRepository.saveBillValues(billValues, newQuotation.getPatientName());
            // we get the dental procedures from the newQuotationMessage and stores them in the command line database.
            writeBillRepository.saveDentalProcedures(newQuotation.getImprovementPlan(), newQuotation.getPatientName());
            // we report the event to the query line database.
            quotationPublished.reportEvent(billValues,newQuotation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
