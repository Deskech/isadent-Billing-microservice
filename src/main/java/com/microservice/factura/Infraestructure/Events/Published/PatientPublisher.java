package com.microservice.factura.Infraestructure.Events.Published;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Domain.Events.Published.PatientPublished;
import com.microservice.factura.Infraestructure.Entity.CommandLine.WriteBillEntity;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * this is the command line patient's publisher to the Query listener
 */
@Component
public class PatientPublisher implements PatientPublished<WriteBillEntity> {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    public PatientPublisher(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper){
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper= objectMapper;
    }

    /**
     *
     * @param event represent the newPatient that needs to be persisted in the query line database
     */
    @SneakyThrows
    @Override
    public void reportEvent(WriteBillEntity event) {
        String pacienteToPublish = objectMapper.writeValueAsString(event);
        rabbitTemplate.convertAndSend("actualizarQuery", "pacienteOcurrido",pacienteToPublish);
    }
}
