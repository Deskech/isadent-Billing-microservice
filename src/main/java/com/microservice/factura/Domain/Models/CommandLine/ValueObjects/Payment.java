package com.microservice.factura.Domain.Models.CommandLine.ValueObjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
/**
 * Represents the payments made by the patient over time.
 * Its value is cumulative with previous payments.
 * */
@Getter
@EqualsAndHashCode

public final class Payment {
    private final Double paymentBill;
    
    public Payment(Double paymentBill){
        this.paymentBill = paymentBill;
    }

}
