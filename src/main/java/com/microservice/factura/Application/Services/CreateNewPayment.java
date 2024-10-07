package com.microservice.factura.Application.Services;

import com.microservice.factura.Application.Dtos.NewPaymentRequest;
import com.microservice.factura.Domain.Services.NewPayment;
import org.springframework.stereotype.Service;

/**
 * This case of use creates a new payment when the client has dode a new one
 * and the values in the database need to be updated
 */
@Service
public class CreateNewPayment {
    private final NewPayment<NewPaymentRequest> newPayment;

    public CreateNewPayment(NewPayment<NewPaymentRequest> newPayment) {
        this.newPayment = newPayment;
    }

    /**
     *
     * @param newPaymentRequest represents the new payment the patient's has done including his dame and the payment amount
     */
    public void darNuevosValores(NewPaymentRequest newPaymentRequest) {
        newPayment.alternatePayment(newPaymentRequest);

    }
}
