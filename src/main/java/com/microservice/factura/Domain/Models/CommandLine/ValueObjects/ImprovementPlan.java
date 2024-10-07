package com.microservice.factura.Domain.Models.CommandLine.ValueObjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 Represents the medical procedures the patient must pay for.
   These values are fixed and do not change over time.
 */
@Getter
@EqualsAndHashCode
public final class ImprovementPlan {
    private final String dentalProcedure;
    private final Double price;

    public ImprovementPlan(String dentalProcedure, Double price) {
        this.dentalProcedure = dentalProcedure;
        this.price = price;
    }
}
