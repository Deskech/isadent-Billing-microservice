package com.microservice.factura.Infraestructure.Mappers.Implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Application.Dtos.NewPaymentRequest;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.NewPaymentReqMapper;
import org.springframework.stereotype.Component;

/**
 * This is the NewPayment mapper implementation
 */
@Component
public class NewPaymentReqImpl implements NewPaymentReqMapper {
    private final ObjectMapper objectMapper;

    public NewPaymentReqImpl(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    /**
     *
     * @param newPaymentRequest this represents the payment value and the patient's name in a single object
     * @return NewPaymentRequest instance
     */
    @Override
    public NewPaymentRequest create(String newPaymentRequest) {
        try {
            JsonNode jsonNode = objectMapper.readTree(newPaymentRequest);
            String patientName = jsonNode.get("patientName").asText();
            Double paymentValue = jsonNode.get("paymentValue").asDouble();
            return new NewPaymentRequest(patientName, paymentValue);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
