package com.microservice.factura.Domain.Events.Publicados;

/**
 *
 * @param <T> (writeBillEntity)
 *          this is responsible to report a new patient store in the command line database
 */
public interface PatientPublished<T> {
    /**
     *
     * @param event represent the newPatient that needs to be persisted in the query line database
     */
    void reportEvent(T event);
}
