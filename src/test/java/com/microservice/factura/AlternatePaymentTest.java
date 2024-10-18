package com.microservice.factura;

import com.microservice.factura.Application.Dtos.CacheUpdatedValues;
import com.microservice.factura.Application.Dtos.NewPaymentRequest;
import com.microservice.factura.Application.Dtos.PatientBillDto;
import com.microservice.factura.Application.Services.ShowBill;

import com.microservice.factura.Domain.Services.NewPayment;

import com.microservice.factura.Infraestructure.Services.CacheBillValues;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AlternatePaymentTest {
    @Autowired
    private NewPayment<NewPaymentRequest> newPayment;
    @Autowired
    private ShowBill showBill;
    @Autowired
    CacheBillValues cacheBillValues;
    @Test
    @Rollback
    void seeBill(){
        PatientBillDto patientBillDto = new PatientBillDto("jose manuel");

        assertNotNull( showBill.bill(patientBillDto));

        NewPaymentRequest newPaymentRequest = new NewPaymentRequest("jose manuel",900.00);
        newPayment.alternatePayment(newPaymentRequest);

        assertNotNull(showBill.bill(patientBillDto));

        CacheUpdatedValues cacheUpdatedValues =  cacheBillValues.getCache("jose manuel");
        assertNotNull(cacheUpdatedValues);
        System.out.println(cacheUpdatedValues.getRemainingCurrency());
    }



}
