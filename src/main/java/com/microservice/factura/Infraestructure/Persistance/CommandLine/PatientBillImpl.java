package com.microservice.factura.Infraestructure.Persistance.CommandLine;

import com.microservice.factura.Domain.Events.Published.PatientPublished;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.PatientBill;
import com.microservice.factura.Domain.Repository.CommandLine.PatientBillRepository;
import com.microservice.factura.Infraestructure.Entity.CommandLine.WriteBillEntity;
import com.microservice.factura.Infraestructure.Repository.CommandLine.PatientBillJpaRepository;
import org.springframework.stereotype.Component;

/**
 * This is the patients bill domain repository implementation
 */
@Component
public class PatientBillImpl implements PatientBillRepository {

    private final PatientBillJpaRepository patientBillJpaRepository;
    private final PatientPublished<WriteBillEntity> patientPublished;
    public PatientBillImpl(PatientBillJpaRepository patientBillJpaRepository, PatientPublished<WriteBillEntity> patientPublished){
        this.patientBillJpaRepository = patientBillJpaRepository;
        this.patientPublished = patientPublished;

    }

    /**
     *
     * @param patientBill this represents the new patient's personal information and the bill id to be stored
     */
    @Override
    public void savePatientBill(PatientBill patientBill) {
        try {
            // we translate the aggregate data so that the Jpa repository can understand it
            WriteBillEntity patient = new WriteBillEntity();
            patient.setBillId(patientBill.getBillId());
            patient.setPatientIdentification(patientBill.getPatientInformation().getPatientIdentification());
            patient.setPatientDirection(patientBill.getPatientInformation().getPatientDirection());
            patient.setPatientName(patientBill.getPatientInformation().getPatientName());
            patientBillJpaRepository.save(patient);
            patientPublished.reportEvent(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
