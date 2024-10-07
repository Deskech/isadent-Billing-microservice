package com.microservice.factura.Application.Services;

import com.microservice.factura.Domain.Models.CommandLine.Aggregates.PatientBill;
import com.microservice.factura.Domain.Repository.CommandLine.PatientBillRepository;
import org.springframework.stereotype.Service;

/**
 * this case of use saves a new patient in the database
 */
@Service
public class SaveNewPatient {
    private final PatientBillRepository patientBillRepository;

    public SaveNewPatient(PatientBillRepository patientBillRepository){
        this.patientBillRepository = patientBillRepository;
    }

    /**
     *
     * @param patientBill represents the patient's personal information and the bill id
     */
    public void save(PatientBill patientBill){
        patientBillRepository.savePatientBill(patientBill);

    }

}
