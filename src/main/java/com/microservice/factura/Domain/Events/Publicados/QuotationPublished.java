package com.microservice.factura.Domain.Events.Publicados;
/**
 *
 * @param <T> (BillValues, NewQuotationMessage) is responsible to report the new BillValues and dentalProcedures when it is stored
 *           in the command line database
 */
public interface QuotationPublished<T,A>{
    /**
     *
     * @param event represents the updated patient's bill values
     * @param dentalProcedures represent the updated patient's dental procedures
     */
    void reportEvent(T event, A dentalProcedures);
}
