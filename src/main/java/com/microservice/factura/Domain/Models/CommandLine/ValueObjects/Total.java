package com.microservice.factura.Domain.Models.CommandLine.ValueObjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
/**
 *Represents the total bill that the patient has to pay.
 * this value is immutable and is the overall cost of services
 */
@Getter
@EqualsAndHashCode

public  final class Total {

    private final Double totalBill;

    public Total(Double totalBill){
        this.totalBill = totalBill;
    }
}
