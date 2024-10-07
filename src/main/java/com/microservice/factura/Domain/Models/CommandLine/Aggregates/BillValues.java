package com.microservice.factura.Domain.Models.CommandLine.Aggregates;

import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Payment;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Remaining;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Total;
import lombok.Getter;
/**
 * Represents the monetary values of the patient's bill, including payment, total, and remaining balance.
 * This class defines the rules for persisting these values in the database.
 */
@Getter
public class BillValues {
    private final Payment paymentBill;
    private final Total totalBill;
    private final Remaining remainingBalance;
    private final String paymentCurrency;
    private final String totalCurrency;
    private final String remainingBalanceCurrency;

    public BillValues(Payment paymentBill, Total totalBill, String paymentCurrency, String totalCurrency, Remaining remainingBalance,
                      String remainingBalanceCurrency
    ){
        this.paymentBill = paymentBill;
        this.totalBill = totalBill;
        this.paymentCurrency = paymentCurrency;
        this.totalCurrency = totalCurrency;
        this.remainingBalance = remainingBalance;
        this.remainingBalanceCurrency = remainingBalanceCurrency;
    }
    /**
     * Creates a new instance of bill values
     * @params payment, total,remainingBalance, and its values in money format. Must not be null.
     * @returns a new instance of BillValues ready to be persisted.
     */
    public static BillValues updateValores(Payment paymentBill, Total totalBill, String paymentCurrency, String totalCurrency, Remaining remainingBalance, String remainingBalanceCurrency){
        if (paymentBill == null || totalBill == null || remainingBalance == null) {
            throw new IllegalArgumentException("Payment, totalBill or remainingBalance cannot be null");
        }
        if (paymentBill.getPaymentBill() > totalBill.getTotalBill()) {
            throw  new IllegalArgumentException("the payment can not be more than the total");
        }
        if (remainingBalance.getRemainingPayment() < 0 || remainingBalance.getRemainingPayment() > totalBill.getTotalBill()) {
            throw new IllegalArgumentException("the remaining balance can not be less than zero nor more than the total");
        }
        return new BillValues(paymentBill, totalBill, paymentCurrency,totalCurrency, remainingBalance, remainingBalanceCurrency);
    }
}
