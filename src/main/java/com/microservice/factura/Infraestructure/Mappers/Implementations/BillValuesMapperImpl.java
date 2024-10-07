package com.microservice.factura.Infraestructure.Mappers.Implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Payment;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Remaining;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Total;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.BillValuesMapper;
import org.springframework.stereotype.Component;

/**
 * this is the bill values mapper implementation
 */
@Component
public class BillValuesMapperImpl implements BillValuesMapper {
        private final ObjectMapper objectMapper;
        public BillValuesMapperImpl(ObjectMapper objectMapper){
            this.objectMapper= objectMapper;
        }

    /**
     *
     * @param billValuesString represents the bill vales string that needs to be a Bill values Object
     * @return a new instance of the patient's bill monetary values
     */
    @Override
    public BillValues toClass(String billValuesString) {

        try {
            JsonNode jsonNode = objectMapper.readTree(billValuesString);
            JsonNode valoresFacturaJson = jsonNode.get("billValues");
            Payment payment = new Payment(valoresFacturaJson.get("paymentBill").get("paymentBill").asDouble());
            Total total = new Total(valoresFacturaJson.get("totalBill").get("totalBill").asDouble());
            Remaining remaining = new Remaining(valoresFacturaJson.get("remainingBalance").get("remainingPayment").asDouble());
            String abonoCurrency = valoresFacturaJson.get("paymentCurrency").asText();
            String totalCurrency = valoresFacturaJson.get("totalCurrency").asText();
            String restanteCurrency= valoresFacturaJson.get("remainingBalanceCurrency").asText();
            return BillValues.updateValores(payment,total,abonoCurrency,totalCurrency, remaining,restanteCurrency);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
