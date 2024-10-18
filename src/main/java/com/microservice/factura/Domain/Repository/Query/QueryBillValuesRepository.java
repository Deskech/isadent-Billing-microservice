package com.microservice.factura.Domain.Repository.Query;

import com.microservice.factura.Domain.Models.Query.QueryBillValues;

/**
 * Represents the values that needs to be read to calculate the patient's bill monetaryValues
 * these values are stored in the query line database
 */
public interface QueryBillValuesRepository {
    /**
     *
     * @param patientName that did a new Payment
     * @return old Remaining payment and the last payment
     */
    QueryBillValues getRemainingAndPayment(String patientName);
}
