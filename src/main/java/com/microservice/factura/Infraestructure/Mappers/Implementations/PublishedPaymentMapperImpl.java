package com.microservice.factura.Infraestructure.Mappers.Implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Infraestructure.Events.Published.Dtos.PaymentPublishedEvent;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.PublishedPaymentMapper;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.BillValuesMapper;
import org.springframework.stereotype.Component;

/**
 * This is the publishedPayment mapper implementation
 */
@Component
public class PublishedPaymentMapperImpl implements PublishedPaymentMapper {
    private final ObjectMapper objectMapper;
    private final BillValuesMapper billValuesMapper;
    public PublishedPaymentMapperImpl(ObjectMapper objectMapper, BillValuesMapper billValuesMapper){
        this.objectMapper = objectMapper;
        this.billValuesMapper= billValuesMapper;
    }

    /**
     *
     * @param publishedPayment this string represents the PublishedPayment object that needs to be a class
     * @return PaymentPublishedEvent instance
     */
    @Override
    public PaymentPublishedEvent create(String publishedPayment) {
        try {
            JsonNode jsonNode = objectMapper.readTree(publishedPayment);
            String nombrePaciente = jsonNode.get("patientName").asText();
            BillValues billValues = billValuesMapper.toClass(publishedPayment);
            return new PaymentPublishedEvent(billValues,nombrePaciente);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
