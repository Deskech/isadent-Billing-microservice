package com.microservice.factura.Infraestructure.Repository.Query;

import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * this repository returns the patient's bill
 */

@Repository
public interface QueryBillJpaRepository extends JpaRepository<QueryBillEntity, String> {

    @Query("select p from QueryBillEntity p where p.patientName= :patientName")
    QueryBillEntity showBill(@Param("patientName")String patientName);


}
