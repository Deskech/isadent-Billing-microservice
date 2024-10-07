package com.microservice.factura.Infraestructure.Repository.CommandLine;

import com.microservice.factura.Infraestructure.Entity.CommandLine.WriteBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is the repository that saves the patient's information and the bill id
 */
@Repository
public interface PatientBillJpaRepository extends JpaRepository<WriteBillEntity,String> {

}
