package com.microservice.factura.Domain.Services;

/**
 *this service used when the doctor has done a new Quotation for the Patient and
 * the values needs to get updated
 */
public interface NewQuotation<T> {
    /**
     *
     * @param newQuotation this is an object that is listened from the Quotation microservice
     */
    void saveNewQuotation(T newQuotation);
}
