package com.microservice.factura.Infraestructure.Events.Published.Dtos;

import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import lombok.Getter;

/**
 * this represents the new Quotation Stored en the command line database, includes monetary values,
 * dental procedures and the patient's name
 */
@Getter
public class QuotationPublishedEvent {
    private final BillValues billValues;
    private final String dentalProcedures;
    private final String patientName;
    public QuotationPublishedEvent(BillValues billValues, String dentalProcedures, String patientName){
        this.dentalProcedures= dentalProcedures;
        this.billValues = billValues;
        this.patientName= patientName;
    }

}
