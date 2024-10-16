package com.microservice.factura.Domain.Models.Query;


import lombok.Getter;

/**
 * Represents the patient's bill view. Only shows the relevant information for the doctor,
 *          including the BillValues in a Currency Format.
 */
@Getter
public class QueryBill {
    private final String remainingPaymentCurrency;
    private final String paymentCurrency;
    private final String totalCurrency;
    private final String patientName;
    private final String patientIdentification;
    private final String dentalProcedures;

    public QueryBill(String remainingPaymentCurrency, String paymentCurrency, String totalCurrency,
                     String patientName, String patientIdentification, String dentalProcedures
    ) {
        this.remainingPaymentCurrency = remainingPaymentCurrency;
        this.paymentCurrency = paymentCurrency;
        this.totalCurrency = totalCurrency;
        this.patientName = patientName;
        this.patientIdentification = patientIdentification;
        this.dentalProcedures = dentalProcedures;
    }

}
