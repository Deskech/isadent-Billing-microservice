package com.microservice.factura.Application.Services;

import com.microservice.factura.Application.Dtos.PatientBillDto;
import com.microservice.factura.Domain.Models.Query.QueryBill;
import com.microservice.factura.Domain.Repository.Query.QueryBillRepository;
import org.springframework.stereotype.Service;

/**
 * this case of use show the patient's bill
 */
@Service
public class ShowBill {

    private final QueryBillRepository queryBillRepository;

    public ShowBill(QueryBillRepository queryBillRepository){
        this.queryBillRepository = queryBillRepository;
    }

    /**
     *
     * @param patientName represents the patient's name
     * @return QueryBill (formatted view of the bill)
     */

    public QueryBill bill(PatientBillDto patientName){
        String patientNameString = patientName.getPatientName();
        return queryBillRepository.showBill(patientNameString);
    }
}
