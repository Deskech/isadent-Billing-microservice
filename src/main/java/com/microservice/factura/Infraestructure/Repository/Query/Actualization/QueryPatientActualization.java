package com.microservice.factura.Infraestructure.Repository.Query.Actualization;

import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * this repository stores the patient's information and the bill id in the query line database
 */
@Repository
public interface QueryPatientActualization extends JpaRepository<QueryBillEntity,String> {
}
