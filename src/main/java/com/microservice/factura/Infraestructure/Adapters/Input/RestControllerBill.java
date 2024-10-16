package com.microservice.factura.Infraestructure.Adapters.Input;


import com.microservice.factura.Application.Dtos.PatientBillDto;
import com.microservice.factura.Application.Services.ShowBill;
import com.microservice.factura.Domain.Models.Query.QueryBill;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller used for showing patient's bill
 */
@RestController
public class RestControllerBill {
    private final ShowBill showBill;

    public RestControllerBill(ShowBill showBill) {
        this.showBill = showBill;

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

}
