package com.microservice.factura.Domain.Services;

/**
 *This service adds a new Payment to an existing one
 */

public interface CalculatePayment {
    /**
     *
     * @param lastPayment represents the last payment done
     * @param newPayment represents the new payment done
     * @return a new payment value
     */
    Double addPayment(Double lastPayment, Double newPayment);
}
