package com.microservice.factura.Infraestructure.Events.Publicado;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Application.Dtos.NewQuotationMessage;
import com.microservice.factura.Domain.Events.Publicados.QuotationPublished;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Infraestructure.Events.Publicado.Dtos.QuotationPublishedEvent;
import com.microservice.factura.Infraestructure.Factories.Interfaces.PublishedQuotationFactory;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * this is the Quotation command line Publisher Query listener
 */
@Component
public class QuotationPublisher implements QuotationPublished<BillValues, NewQuotationMessage> {
    private final RabbitTemplate rabbitTemplate;
    private final PublishedQuotationFactory publishedQuotationFactory;
    private final ObjectMapper objectMapper;
    public QuotationPublisher(RabbitTemplate rabbitTemplate, PublishedQuotationFactory publishedQuotationFactory, ObjectMapper objectMapper){
        this.rabbitTemplate= rabbitTemplate;
        this.publishedQuotationFactory = publishedQuotationFactory;
        this.objectMapper= objectMapper;
    }

    /**
     *
     * @param event represents the updated patient's bill values
     * @param dentalProcedures represent the updated patient's dental procedures
     */
    @SneakyThrows
    @Override
    public void reportEvent(BillValues event, NewQuotationMessage dentalProcedures) {
        QuotationPublishedEvent quotationPublishedEvent = publishedQuotationFactory
                .createPublishedQuotation(event, dentalProcedures);
        String quotationToSend= objectMapper.writeValueAsString(quotationPublishedEvent);
        rabbitTemplate.convertAndSend("actualizarQuery","cotizacionOcurrido",quotationToSend);
    }
}
