package com.microservice.factura.Infraestructure.Mappers.Implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.ImprovementPlan;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.DentalProceduresMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this is the implementation of the dental procedures mapper
 */
@Component
public class DentalProceduresMapperImpl implements DentalProceduresMapper<ImprovementPlan> {
    private final ObjectMapper objectMapper;

    public DentalProceduresMapperImpl(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
    }

    /**
     *
     * @param dentalProcedures represents the list received from the Quotation microservice
     * @return a String including dental procedures and prices
     */
    @Override
    public String toJson(List<ImprovementPlan> dentalProcedures) {
        try {
            return objectMapper.writeValueAsString(dentalProcedures);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
