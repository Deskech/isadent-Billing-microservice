package com.microservice.factura.Application.Dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a new payment that the patients has done
 * this is used in the payment listener as a dto
 */
@Getter
@Setter
public class NewPaymentRequest {
    private String patientName;
    private Double paymentValue;

    public NewPaymentRequest(String patientName, Double paymentValue) {
        this.paymentValue = paymentValue;
        this.patientName = patientName;
    }

    public NewPaymentRequest() {
    }
}
