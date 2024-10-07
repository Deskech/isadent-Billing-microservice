package com.microservice.factura.Infraestructure.Repository.CommandLine;

import com.microservice.factura.Infraestructure.Entity.CommandLine.WriteBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * This repository is responsible for storing the dental procedures in the command line database
 */
@Repository
public interface WriteBillJpaRepository extends JpaRepository<WriteBillEntity, String> {
    @Modifying
    @Query("update WriteBillEntity f set f.dentalProcedures= :dentalProcedures where f.patientName= :patientName")
    void saveDentalProcedures(@Param("dentalProcedures")String dentalProcedures,@Param("patientName")String patientName);
}
