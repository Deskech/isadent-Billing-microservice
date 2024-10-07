package com.microservice.factura.Domain.Models.CommandLine.ValueObjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
/**
 * Represents the identity of a Patient.
 */
@Getter
@EqualsAndHashCode
public final class Patient {
    private  final String patientName;
    private final String patientIdentification;
    private final String patientDirection;

    public Patient(String patientName, String patientIdentification, String patientDirection){
        this.patientName = patientName;
        this.patientDirection = patientDirection;
        this.patientIdentification = patientIdentification;
    }
}
