package com.microservice.factura.Infraestructure.Events.Published.Dtos;

import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import lombok.Getter;
/**
 * this DTO represents the values updates in the patient's bill including the patient's name.
 */

@Getter
public class PaymentPublishedEvent {

    private final BillValues billValues;
    private final String patientName;

    public PaymentPublishedEvent(BillValues billValues, String patientName){
        this.patientName = patientName;
        this.billValues = billValues;
    }
}
