package com.microservice.factura.Domain.Services;

/**
 * Calculates the remaining payment AFTER a new payment is set
 */
public interface CalculateRemainingBalance {
    /**
     *
     * @param total is the patient's bill total value
     * @param payment is the new payment the patients did
     * @return a new remaining payment
     */
    Double diminuirRestante(Double total, Double payment);
}
