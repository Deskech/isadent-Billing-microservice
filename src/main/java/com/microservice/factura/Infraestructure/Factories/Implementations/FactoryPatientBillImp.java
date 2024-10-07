package com.microservice.factura.Infraestructure.Factories.Implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Domain.Factories.FactoryPatientBill;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.PatientBill;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Patient;
import org.springframework.stereotype.Component;

@Component
public class FactoryPatientBillImp implements FactoryPatientBill {
    private final ObjectMapper objectMapper;

    public FactoryPatientBillImp(ObjectMapper objectMapper){
        this.objectMapper= objectMapper;
    }
    @Override
    public PatientBill toDomain(String patientName) {
        try {
            Patient patient = objectMapper.readValue(patientName, Patient.class);
            return PatientBill.savePacienteFactura(patient);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
