package com.microservice.factura.Infraestructure.Factories.Implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Domain.Factories.FactoryPatientBill;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.PatientBill;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Patient;
import org.springframework.stereotype.Component;

/**
 * This is the Patients Bill object factory implementation
 */
@Component
public class FactoryPatientBillImp implements FactoryPatientBill {
    private final ObjectMapper objectMapper;

    public FactoryPatientBillImp(ObjectMapper objectMapper){
        this.objectMapper= objectMapper;
    }

    /**
     *
     * @param patientInformation represents the object of the new patient stored in the patient microservice
     * @return a new instance of PatientBill
     */
    @Override
    public PatientBill toDomain(String patientInformation) {
        try {
            //since we listen to a string we have to map it first to Object
            Patient patient = objectMapper.readValue(patientInformation, Patient.class);
            //then use the Aggregate's method to create the UUID and save it as an object
            return PatientBill.savePatientBill(patient);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
