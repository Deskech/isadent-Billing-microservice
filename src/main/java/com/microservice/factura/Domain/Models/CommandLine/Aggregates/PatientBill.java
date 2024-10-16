package com.microservice.factura.Domain.Models.CommandLine.Aggregates;


import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Patient;
import lombok.Getter;

import java.util.UUID;
/**
 * Represents the patient's bill, including patient information and the bill ID.
 * This object is persisted in the database.
 */
@Getter
public class PatientBill {
    private final Patient patientInformation;
    private final String billId;

    public PatientBill(Patient patientInformation){
        this.patientInformation = patientInformation;
        this.billId = UUID.randomUUID().toString();
    }
    /**Creates a new instance of the patient's bill.
    * @param patientInformation (patient object). Must not be null.
    * @returns new patientBill object instance.
    */
    public static PatientBill savePatientBill(Patient patientInformation){
        if (patientInformation == null) {
            throw new IllegalArgumentException("patient can not be null");
        }
        return new PatientBill(patientInformation);
    }
}
