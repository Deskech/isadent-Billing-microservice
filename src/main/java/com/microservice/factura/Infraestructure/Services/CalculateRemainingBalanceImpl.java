package com.microservice.factura.Infraestructure.Services;

import com.microservice.factura.Domain.Services.CalculateRemainingBalance;
import org.springframework.stereotype.Component;

/**
 * This is the implementation of the Calculate remaining balance domain service
 */
@Component
public class CalculateRemainingBalanceImpl implements CalculateRemainingBalance {
    /**
     *
     * @param total is the patient's bill total value
     * @param payment is the new payment the patients did
     * @return a new Remaining payment value
     */
    @Override
    public Double diminuirRestante(Double total, Double payment) {
        return total - payment;
    }
}
