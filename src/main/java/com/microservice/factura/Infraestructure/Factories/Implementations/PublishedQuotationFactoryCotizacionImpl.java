package com.microservice.factura.Infraestructure.Factories.Implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Application.Dtos.NewQuotationMessage;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.ImprovementPlan;
import com.microservice.factura.Infraestructure.Events.Published.Dtos.QuotationPublishedEvent;
import com.microservice.factura.Infraestructure.Factories.Interfaces.PublishedQuotationFactory;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.BillValuesMapper;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.DentalProceduresMapper;
import org.springframework.stereotype.Component;

/**
 * this is the factory implementation for the PublishedQuotation
 */
@Component
public class PublishedQuotationFactoryCotizacionImpl implements PublishedQuotationFactory {

    private final DentalProceduresMapper<ImprovementPlan> dentalProceduresMapper;
    private final ObjectMapper objectMapper;
    private final BillValuesMapper billValuesMapper;
    public PublishedQuotationFactoryCotizacionImpl(DentalProceduresMapper<ImprovementPlan> dentalProceduresMapper, ObjectMapper objectMapper,
                                                   BillValuesMapper billValuesMapper){
        this.dentalProceduresMapper = dentalProceduresMapper;
        this.objectMapper = objectMapper;
        this.billValuesMapper = billValuesMapper;
    }

    /**
     *
     * @param billValues represents the updated values
     * @param newQuotationMessage represents the dental procedures
     * @return returns a new instance of PublishedQuotation
     */
    @Override
    public QuotationPublishedEvent createPublishedQuotation(BillValues billValues, NewQuotationMessage newQuotationMessage) {
        String dentalProceduresMapper = this.dentalProceduresMapper.toJson(newQuotationMessage.getImprovementPlan());
        String patientName = newQuotationMessage.getPatientName();

        return new QuotationPublishedEvent(billValues, dentalProceduresMapper, patientName);

    }

    /**
     *
     * @param quotationString represents the new Quotation stored in the command line database
     * @return a new instance of QuotationPublished event ready to be stored in the query line database
     */
    @Override
    public QuotationPublishedEvent deserializeString(String quotationString) {
        try {
            // since we receive a complex string it is necessary to deserialize it manually
            JsonNode jsonNode = objectMapper.readTree(quotationString);
            // we read the patientName
            String patientName = jsonNode.get("patientName").asText();
            // we read the dentalProcedures
            String dentalProcedures = jsonNode.get("dentalProcedures").asText();
            // we use the bill values mapper to create a new instance of billValues
           BillValues billValues = billValuesMapper.toClass(quotationString);
           // create the dto instance
            return new QuotationPublishedEvent(billValues,dentalProcedures,patientName);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al momento de create QuotationPublishedEvent para guardarlo",e);
        }

    }
}
