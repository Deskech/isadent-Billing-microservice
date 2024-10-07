package com.microservice.factura.Domain.Services;

/**
 * This service is responsible for keeping the payments up to date when the patient
 * has done a new payment.
 */
public interface NewPayment<T> {
    /**
     *
     * @param newPayment represents the new payment the patient has done
     */
    void alternatePayment(T newPayment);
}
