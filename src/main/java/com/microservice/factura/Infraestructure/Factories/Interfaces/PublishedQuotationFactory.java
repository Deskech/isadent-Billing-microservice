package com.microservice.factura.Infraestructure.Factories.Interfaces;

import com.microservice.factura.Application.Dtos.NewQuotationMessage;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Infraestructure.Events.Published.Dtos.QuotationPublishedEvent;

/**
 * This is the published quotation factory
 */
public interface PublishedQuotationFactory {
    /**
     *
     * @param billValues represents the updated values
     * @param newQuotationMessage represents the new dental procedures
     * @return QuotationPublishedEvent instance ready to be stored in the query line database
     */
    QuotationPublishedEvent createPublishedQuotation(BillValues billValues, NewQuotationMessage newQuotationMessage);

    /**
     *
     * @param quotationString represents the Quotation stored in the command line
     * @return QuotationPublishedEvent instance ready to be stored in the query line database
     */
    QuotationPublishedEvent deserializeString(String quotationString);
}
