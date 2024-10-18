package com.microservice.factura.Infraestructure.Adapters.Input;


import com.microservice.factura.Application.Dtos.CacheUpdatedValues;
import com.microservice.factura.Application.Dtos.PatientBillDto;
import com.microservice.factura.Application.Services.ShowBill;
import com.microservice.factura.Domain.Models.Query.QueryBill;
import com.microservice.factura.Infraestructure.Services.CacheBillValues;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller used for showing patient's bill
 */
@RestController
public class RestControllerBill {
    private final ShowBill showBill;
    private final CacheBillValues cacheBillValues;
    public RestControllerBill(ShowBill showBill, CacheBillValues cacheBillValues) {
        this.showBill = showBill;
        this.cacheBillValues = cacheBillValues;
    }

    /**
     *
     * @param patientName represents the patient's name in a dto
     * @return a formatted view of the patient's bill
     */
    @CrossOrigin
    @PostMapping("/bill")
    public QueryBill getBill(@RequestBody PatientBillDto patientName) {
        return showBill.bill(patientName);
    }

    /**
     *
     * @param patientName represents the patient's name in a dto
     * @return the bill values stored in the cache
     */
    @CrossOrigin
    @PostMapping("/bill/payment-cache")
    public CacheUpdatedValues getPaymentCache(@RequestBody PatientBillDto patientName){
        return cacheBillValues.getCache(patientName.getPatientName());
    }
}
