package com.microservice.factura.Application.Dtos;

import lombok.Getter;

import java.io.Serializable;

/**
 * Represents the patient's bill monetary values stored in the cache
 */
@Getter
public class CacheUpdatedValues implements Serializable {
    private String remainingCurrency;
    private String totalCurrency;
    private String patientName;
    private String paymentCurrency;

    public CacheUpdatedValues(String remainingCurrency, String totalCurrency, String patientName, String paymentCurrency) {
        this.remainingCurrency = remainingCurrency;
        this.totalCurrency = totalCurrency;
        this.patientName = patientName;
        this.paymentCurrency = paymentCurrency;
    }

    public CacheUpdatedValues() {
    }
}
