package com.microservice.factura.Domain.Repository.CommandLine;

import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.ImprovementPlan;

import java.util.List;
/**
 * Represents the Quotation's dentalProcedures in the patient's bill
 */
public interface WriteBillRepository {
    /**
     * this method is used when a new Quotation has occurred.
     */

    void saveDentalProcedures(List<ImprovementPlan> dentalProcedures, String patientName);
}
