package com.microservice.factura.Domain.Factories;

import com.microservice.factura.Domain.Models.CommandLine.Aggregates.PatientBill;

/**
 * This is the factory for the PatientBill (contains the patient's name)
 */
public interface FactoryPatientBill {
    /**
     *
     * @param patientName represents the object of the new patient stored in the patient microservice
     * @return a new instance of patientBill ( contains the patient's name)
     */
    PatientBill toDomain(String patientName);
}
