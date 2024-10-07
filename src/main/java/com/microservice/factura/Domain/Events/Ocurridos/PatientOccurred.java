package com.microservice.factura.Domain.Events.Ocurridos;

/**
 *
 * @param <T> String.
 * This service is used when a new patient is stored in the patient microservice
 *           and this also stores the patients information in the database and a bill id
 */
public interface PatientOccurred<T> {
    /**
     *
     * @param newPatient this represents an object comming from the Patients microservice.
     */
    void listenNewPaciente(T newPatient);
}
