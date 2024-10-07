package com.microservice.factura.Infraestructure.Repository.Query.Actualization;

import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This repository stores the patient's bill monetary values after a payment is set in the command line database
 */
@Repository
@Transactional(transactionManager = "tm2")
public interface QueryValuesActualization extends JpaRepository<QueryBillEntity,String> {

    @Modifying
    @Query("update QueryBillEntity f set f.payment= :payment, f.paymentCurrency= :paymentCurrency, f.remainingBalance= :remainingBalance, f.remainingBalanceCurrency= :remainingBalanceCurrency where f.patientName= :patientName")
    void updateValuesActualization(@Param("payment")Double payment, @Param("paymentCurrency")String paymentCurrency,
                                   @Param("remainingBalance")Double remainingBalance, @Param("remainingBalanceCurrency")String remainingBalanceCurrency,
                                   @Param("patientName")String patientName);

}
