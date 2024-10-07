package com.microservice.factura.Infraestructure.Repository.Query;


import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * This repository returns the remaining payment and the last payment
 */
@Repository
public interface QueryValuesJpaRepository extends JpaRepository<QueryBillEntity,String> {

    @Query("select q from QueryBillEntity q where q.patientName= :patientName")
    QueryBillEntity getRemainingAndPayment(@Param("patientName")String patientName);
}
