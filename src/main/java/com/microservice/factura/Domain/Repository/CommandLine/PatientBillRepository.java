package com.microservice.factura.Domain.Repository.CommandLine;

import com.microservice.factura.Domain.Models.CommandLine.Aggregates.PatientBill;
/**Represents the patient's bill identifications in the database,
* including the patient's personal information and the bill id.*/
public interface PatientBillRepository {
    /**
     * This method is only used when a new patient event has occurred*/
    void savePatientBill(PatientBill patientBill);
}
