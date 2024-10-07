package com.microservice.factura.Domain.Models.Query;

import lombok.EqualsAndHashCode;
import lombok.Getter;
/**
 * Represents the monetary values of a patient's bill used for calculations.
 * This value object is used when a new payment request is made and the bill needs to be updated.
 */
@Getter
@EqualsAndHashCode

public final class QueryBillValues {
    private final Double payment;
    private final Double remainingPayment;
    private final Double total;
    public QueryBillValues(Double payment, Double remainingPayment, Double total){
        this.payment = payment;
        this.remainingPayment = remainingPayment;
        this.total= total;
    }
}
