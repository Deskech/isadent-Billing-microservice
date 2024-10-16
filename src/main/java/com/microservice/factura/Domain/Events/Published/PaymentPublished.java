package com.microservice.factura.Domain.Events.Published;

/**
 *
 * @param <T> (BillValues) is responsible to report a new payment when it is stored
 *           in the command line database
 */
public interface PaymentPublished<T> {
    /**
     *
     * @param event represents the updated bill values
     * @param patientName represents the patient who has paid
     */
    void reportEvent(T event, String patientName);
}
