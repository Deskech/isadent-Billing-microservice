package com.microservice.factura.Infraestructure.Repository.Query.Actualization;

import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * this repository stores the Quotation's dental procedures and the patient's bill monetary values in the
 * query line database.
 */
@Repository
@Transactional(transactionManager = "tm2")
public interface QueryQuotationActualization extends JpaRepository<QueryBillEntity, String> {

   @Modifying
    @Query("update QueryBillEntity f set f.total= :total,  f.totalCurrency= :totalCurrency, f.payment= :payment, f.paymentCurrency= :paymentCurrency,f.dentalProcedures= :dentalProcedures, f.remainingBalance = :remainingBalance, f.remainingBalanceCurrency= :remainingBalanceCurrency where f.patientName= :patientName")

   void saveQuotation(@Param("total")Double total, @Param("totalCurrency")String totalCurrency, @Param("payment")Double payment,
                      @Param("paymentCurrency")String paymentCurrency, @Param("dentalProcedures") String dentalProcedures,
                      @Param("remainingBalance")Double remainingBalance, @Param("remainingBalanceCurrency")String remainingBalanceCurrency,
                      @Param("patientName") String patientName);
}
