package com.microservice.factura.Infraestructure.Persistance.CommandLine;

import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Domain.Repository.CommandLine.BillValuesRepository;
import com.microservice.factura.Infraestructure.Repository.CommandLine.BillValuesJpaRepository;
import org.springframework.stereotype.Component;

/**
 * This is the Bill values domain repository implementation
 */
@Component
public class BillValuesImpl implements BillValuesRepository {
    private final BillValuesJpaRepository billValuesJpaRepository;

    public BillValuesImpl(BillValuesJpaRepository billValuesJpaRepository) {
        this.billValuesJpaRepository = billValuesJpaRepository;
    }

    /**
     *
     * @param billValues represents the values to be persisted
     * @param patientName represents the patient's name so that the repository knows where to store it
     */
    @Override
    public void saveBillValues(BillValues billValues, String patientName) {
        try {
            //The purpose of this is to get every value Including the total to persist for the first time
            billValuesJpaRepository.saveBillValues(billValues.getPaymentBill().getPaymentBill(), billValues.getPaymentCurrency(),
                    billValues.getTotalBill().getTotalBill(), billValues.getTotalCurrency(), billValues.getRemainingBalance().getRemainingPayment(),
                    billValues.getRemainingBalanceCurrency(), patientName);
        } catch (Exception e ){
            System.err.println("Ha ocurrido un problema al momento de actualizar Valor Monetario"+ e.getMessage());
        }
    }

    /**
     *
     * @param billValues represents the new bill values after a new payment is set
     * @param patientName represents the patient's name so that the repository know where to store it
     */
    @Override
    public void updateBillValues(BillValues billValues, String patientName) {
            try {
                /* The purpose of this is to get every value so
                that the jpa repository can persis it
                (update total,payment,restante and its currencyFormats)*/
                billValuesJpaRepository.updateBillValues(billValues.getPaymentBill().getPaymentBill(), billValues.getPaymentCurrency(),
                        billValues.getRemainingBalance().getRemainingPayment(), billValues.getRemainingBalanceCurrency(), patientName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
}
