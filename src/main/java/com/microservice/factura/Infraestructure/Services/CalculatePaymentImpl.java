package com.microservice.factura.Infraestructure.Services;

import com.microservice.factura.Domain.Services.CalculatePayment;
import org.springframework.stereotype.Component;

/**
 * this service is used when a new payment is set and the payment's total amounts
 * needs to be updated.
 */
@Component
public class CalculatePaymentImpl implements CalculatePayment {
    /**
     * This service assumes the patient has made payments before.
     * @param lastPayment represents the last payment done or the total amount stored in the query line database
     * @param newPayment represents the new payment done.
     * @return a double value that represents the new payment's total amount.
     */
    @Override
    public Double addPayment(Double lastPayment, Double newPayment) {
        return lastPayment + newPayment;
    }
}
