package com.microservice.factura.Domain.Events.Ocurridos;

/**
 *
 * @param <T> String
 *           This interface is used when a new Quotation is created
 */
public interface QuotationOccurred<T> {

    /**
     *
     * @param newQuotation represent the object comming from the Quotations microservice
     */
    void listenNewQuotation(T newQuotation);
}
