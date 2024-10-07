package com.microservice.factura.Application.Services;

import com.microservice.factura.Application.Dtos.NewQuotationMessage;
import com.microservice.factura.Domain.Services.NewQuotation;
import org.springframework.stereotype.Service;

/**
 * This case of use saves a new Quotation
 */
@Service
public class CreateNewQuotation {
    private final NewQuotation<NewQuotationMessage> newQuotation;

    public CreateNewQuotation(NewQuotation<NewQuotationMessage> newQuotation){
        this.newQuotation = newQuotation;
    }

    /**
     *
     * @param newQuotationMessage represents the message comming from the Quotation microservice including dental procedures and
     *                            bill values.
     *
     */
    public void save(NewQuotationMessage newQuotationMessage){
        newQuotation.saveNewQuotation(newQuotationMessage);


    }
}
