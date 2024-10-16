package com.microservice.factura.Infraestructure.Events.Published;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Domain.Events.Published.PaymentPublished;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Infraestructure.Events.Published.Dtos.PaymentPublishedEvent;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * this is the command line payment publisher to the Query listener
 */
@Component
public class PaymentPublisher implements PaymentPublished<BillValues> {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    public PaymentPublisher(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper){
        this.rabbitTemplate= rabbitTemplate;
        this.objectMapper= objectMapper;
    }

    /**
     *
     * @param event represents the updated bill values
     * @param patientName represents the patient who has paid
     */
    @SneakyThrows
    @Override
    public void reportEvent(BillValues event, String patientName) {
        PaymentPublishedEvent paymentPublishedEvent = new PaymentPublishedEvent(event, patientName);
        String abonoJson = objectMapper.writeValueAsString(paymentPublishedEvent);
        rabbitTemplate.convertAndSend("actualizarQuery","abonoOcurrido",abonoJson);

    }
}

