package com.microservice.factura.Domain.Events.Occurred;

/**
 *
 * @param <T> String
 *           this interface is used when a new Payment is stored in the
 *           payment microservice
 */
public interface PaymentOccurred<T> {
    /**
     *
     * @param newPaymentRequest represents the object comming from the payment microservice
     */
    void listenNewPayment(T newPaymentRequest);
}
