package com.microservice.factura.Infraestructure.Persistance.Query.Actualization;

import com.microservice.factura.Infraestructure.Events.Published.Dtos.QuotationPublishedEvent;
import com.microservice.factura.Infraestructure.Repository.Query.Actualization.QueryQuotationActualization;
import org.springframework.stereotype.Component;

/**
 * This saves a new Quotation that has been stored in the command line database
 */
@Component
public class QueryQuotation {

    private final QueryQuotationActualization queryQuotationActualization;

    public QueryQuotation(QueryQuotationActualization queryQuotationActualization){
        this.queryQuotationActualization = queryQuotationActualization;
    }

    public void saveQuotation(QuotationPublishedEvent event){
        queryQuotationActualization.saveQuotation(event.getBillValues().getTotalBill().getTotalBill(),
                event.getBillValues().getTotalCurrency(), event.getBillValues().getPaymentBill().getPaymentBill(),
                event.getBillValues().getPaymentCurrency(), event.getDentalProcedures(), event.getBillValues().getRemainingBalance().getRemainingPayment(),
                event.getBillValues().getRemainingBalanceCurrency(),event.getPatientName());
    }
}
