package com.microservice.factura.Infraestructure.Adapters.Input;

import com.microservice.factura.Application.Services.SaveNewPatient;
import com.microservice.factura.Domain.Events.Ocurridos.PatientOccurred;
import com.microservice.factura.Domain.Factories.FactoryPatientBill;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.PatientBill;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * This is the listener for the new patient event.
 */
@Component
public class NewPatientOccurredListener implements PatientOccurred<String> {
    private final SaveNewPatient saveNewPatient;
    private final FactoryPatientBill factoryPatientBill;

    public NewPatientOccurredListener(SaveNewPatient saveNewPatient, FactoryPatientBill factoryPatientBill) {
        this.saveNewPatient = saveNewPatient;
        this.factoryPatientBill = factoryPatientBill;
    }

    /**
     *
     * @param newPatient this represents an object comming from the Patients microservice.
     */
    @RabbitListener(queues = "facturasQueue")
    @Override
    public void listenNewPaciente(String newPatient) {
        try {
            //1. map the newPatient object to a domain model
            PatientBill patientBill = factoryPatientBill.toDomain(newPatient);
            //2. we store the domain model in the database
            saveNewPatient.save(patientBill);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
