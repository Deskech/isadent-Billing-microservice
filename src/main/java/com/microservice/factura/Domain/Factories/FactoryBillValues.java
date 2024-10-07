package com.microservice.factura.Domain.Factories;

import com.microservice.factura.Application.Dtos.NewPaymentRequest;
import com.microservice.factura.Application.Dtos.NewQuotationMessage;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Domain.Models.Query.QueryBillValues;

/**
 * this is the factory for the patient's bill monetary values (BillValues)
 */
public interface FactoryBillValues {
    /**
     * this method assumes the patients has done previous payments.
     * @param queryBillValues this represents the "old" values stored in the query line database
     * @param newPaymentRequest this represents the new payment that the patient has done
     * @return a new instance of Bill values(patient's bill monetary values)
     */
    BillValues createBillValues(QueryBillValues queryBillValues, NewPaymentRequest newPaymentRequest);

    /**
     * this method assumes the patient has no payments yet.
     * @param newQuotationMessage this represents the Quotation's object received from the Quotation microservices
     * @return a new instance of Bill Values(patient's bill monetary values)
     */
    BillValues billValuesFirsTime(NewQuotationMessage newQuotationMessage);
}
