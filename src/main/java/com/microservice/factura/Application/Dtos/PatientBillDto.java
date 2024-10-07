package com.microservice.factura.Application.Dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the patient's name that needs to see his bill
 */
@Getter
@Setter
public class PatientBillDto {
   private String patientName;

    public PatientBillDto(String patientName){
        this.patientName = patientName;
    }
    public PatientBillDto(){}
}
