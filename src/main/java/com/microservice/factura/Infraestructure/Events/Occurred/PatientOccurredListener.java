package com.microservice.factura.Infraestructure.Events.Occurred;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Infraestructure.Entity.CommandLine.WriteBillEntity;
import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import com.microservice.factura.Infraestructure.Repository.Query.Actualization.QueryPatientActualization;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * This is the listener of the Patients that are stored in the Command line database
 */
@Component
public class PatientOccurredListener {

    private final QueryPatientActualization queryPatientActualization;
    private final ObjectMapper objectMapper;
    public PatientOccurredListener(QueryPatientActualization queryPatientActualization, ObjectMapper objectMapper){
        this.queryPatientActualization = queryPatientActualization;
        this.objectMapper= objectMapper;
    }

    /**
     *
     * @param newPatient represents the new patients stored in the command line database
     */
    @SneakyThrows
    @RabbitListener(queues = "pacienteActualizadoQueue")
    public void savePatient(String newPatient){
        //since we receive a String it is necessary to map it to the real Object
        WriteBillEntity writeBillEntity = objectMapper.readValue(newPatient, WriteBillEntity.class);
        // then map it to the Jpa entity to store it in the Query database
        QueryBillEntity patient = new QueryBillEntity();
        patient.setPatientIdentification(writeBillEntity.getPatientIdentification());
        patient.setBillId(writeBillEntity.getBillId());
        patient.setPatientName(writeBillEntity.getPatientName());
        patient.setPatientDirection(writeBillEntity.getPatientDirection());
        queryPatientActualization.save(patient);
    }

}
