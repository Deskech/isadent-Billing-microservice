package com.microservice.factura.Application.Dtos;


import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.ImprovementPlan;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Represents the message comming from the Quotation microservice when a new Quotation has been set.
 * This is used in the Quotation Listener as a dto
 */
@Getter
@Setter
public class NewQuotationMessage {
    private List<ImprovementPlan> improvementPlan;
    private  Double payment;
    private  String patientName;
    private  Double total;
    private  String date;

    public NewQuotationMessage(List<ImprovementPlan> improvementPlan, Double payment, String patientName, Double total, String date){
        this.improvementPlan = improvementPlan;
        this.payment = payment;
        this.patientName=patientName;
        this.total=total;
        this.date = date;
    }
}
