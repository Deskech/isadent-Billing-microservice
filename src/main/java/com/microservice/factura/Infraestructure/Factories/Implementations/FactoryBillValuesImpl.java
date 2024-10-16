package com.microservice.factura.Infraestructure.Factories.Implementations;

import com.microservice.factura.Application.Dtos.NewPaymentRequest;
import com.microservice.factura.Application.Dtos.NewQuotationMessage;
import com.microservice.factura.Domain.Factories.FactoryBillValues;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Payment;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Remaining;
import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.Total;
import com.microservice.factura.Domain.Models.Query.QueryBillValues;
import com.microservice.factura.Domain.Services.CalculatePayment;
import com.microservice.factura.Domain.Services.CalculateRemainingBalance;
import com.microservice.factura.Domain.Services.Currency;
import org.springframework.stereotype.Component;

/**
 * this is the factory implementation for the BillValues
 */
@Component
public class FactoryBillValuesImpl implements FactoryBillValues {
    private final CalculatePayment calculatePayment;
    private final CalculateRemainingBalance calculateRemainingBalance;
    private final Currency currency;

    public FactoryBillValuesImpl(CalculatePayment calculatePayment, CalculateRemainingBalance calculateRemainingBalance, Currency currency){
        this.calculatePayment = calculatePayment;
        this.calculateRemainingBalance = calculateRemainingBalance;
        this.currency= currency;
    }

    /**
     *
     * @param lastValues this represents the "old" values stored in the query line database
     * @param newPaymentRequest this represents the new payment that the patient has done
     * @return new instance of BillValues
     */
    @Override
    public BillValues createBillValues(QueryBillValues lastValues, NewPaymentRequest newPaymentRequest) {

        Double payment = calculatePayment.addPayment(lastValues.getPayment(), newPaymentRequest.getPaymentValue());
        Double remainingPayment = calculateRemainingBalance.diminuirRestante(lastValues.getTotal(), payment);
        Total total= new Total(lastValues.getTotal());
        //we create the currency formatting
        String paymentCurrency = currency.format(payment);
        String remainingPaymentCurrency = currency.format(remainingPayment);
        String totalCurrency = currency.format(total.getTotalBill());
        //We create a new Instance of Value Obj
        Payment newPayment = new Payment(payment);
        Remaining newRemaining = new Remaining(remainingPayment);
        return  BillValues.updateValues(newPayment,total, paymentCurrency,totalCurrency, newRemaining, remainingPaymentCurrency);
    }

    /**
     * this method assumes that the user has no payments yet or this is the firts one
     * @param newQuotationMessage this represents the Quotation's object received from the Quotation microservices
     * @return new instance of BillValues
     */
    @Override
    public BillValues billValuesFirsTime(NewQuotationMessage newQuotationMessage) {
        //We begin with setting out Value Objs
        Payment payment = new Payment(newQuotationMessage.getPayment());

        //Do the calculations which in this case is only the remainingPayment because it is first time and there is no total yet nor payment
        Double remainingPayment = calculateRemainingBalance.diminuirRestante(newQuotationMessage.getTotal(), newQuotationMessage.getPayment());
        Remaining newRemaining = new Remaining(remainingPayment);
        Total total = new Total(newQuotationMessage.getTotal());
        //we set our Currency Format this is necessary for the view format
        String totalCurrency = currency.format(total.getTotalBill());
        String remainingPaymentCurrency = currency.format(newRemaining.getRemainingPayment());
        String paymentCurrency = currency.format(payment.getPaymentBill());

        // we set the Value Obj this is important for Persisting the values
       return   BillValues.updateValues(payment, total, paymentCurrency,
                totalCurrency, newRemaining, remainingPaymentCurrency);
    }
}
