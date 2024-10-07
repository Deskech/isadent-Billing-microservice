package com.microservice.factura.Infraestructure.Adapters.Input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Application.Dtos.NewQuotationMessage;
import com.microservice.factura.Application.Services.CreateNewQuotation;
import com.microservice.factura.Domain.Events.Ocurridos.QuotationOccurred;
import lombok.SneakyThrows;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * This is the listener for the Quotations events
 */
@Component
public class NewQuotationOccurredListener implements QuotationOccurred<String> {
    private final CreateNewQuotation createNewQuotation;
    private final ObjectMapper objectMapper;
    public NewQuotationOccurredListener(CreateNewQuotation createNewQuotation, ObjectMapper objectMapper){
        this.createNewQuotation = createNewQuotation;
        this.objectMapper = objectMapper;
    }

    /**
     *
     * @param newQuotation represent the object comming from the Quotations microservice
     */
    @SneakyThrows
    @RabbitListener(queues = "cotizacion")
    @Override
    public void listenNewQuotation(String newQuotation) {
        try {
            //1. map the newQuotation object to an application layer dto
            NewQuotationMessage quotationMessage = objectMapper.readValue(newQuotation, NewQuotationMessage.class);
            //2. store the new dental procedures and patient's bill monetary values
            createNewQuotation.save(quotationMessage);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }

    }
}
