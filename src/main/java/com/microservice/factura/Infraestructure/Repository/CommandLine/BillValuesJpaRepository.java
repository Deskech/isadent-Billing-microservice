package com.microservice.factura.Infraestructure.Repository.CommandLine;

import com.microservice.factura.Infraestructure.Entity.CommandLine.WriteBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * this is the jpa repository that stores the patient's bill new monetary values
 */
@Repository
public interface BillValuesJpaRepository extends JpaRepository<WriteBillEntity, String> {

    @Modifying
    @Query("update WriteBillEntity f set f.payment= :payment, f.paymentCurrency= :paymentCurrency, f.total= :total, f.totalCurrency= :totalCurrency, f.remainingBalance= :remainingBalance, f.remainingBalanceCurrency= :remainingBalanceCurrency where f.patientName= :patientName")
    void saveBillValues(@Param("payment") Double payment, @Param("paymentCurrency") String paymentCurrency,
                        @Param("total") Double total, @Param("totalCurrency") String totalCurrency,
                        @Param("remainingBalance") Double remainingBalance, @Param("remainingBalanceCurrency") String remainingBalanceCurrency,
                        @Param("patientName") String patientName);
    @Modifying
    @Query("update WriteBillEntity f set f.payment= :payment, f.paymentCurrency= :paymentCurrency, f.remainingBalance= :remainingBalance, f.remainingBalanceCurrency= :remainingBalanceCurrency where f.patientName= :patientName")
        void updateBillValues(@Param("payment")Double payment, @Param("paymentCurrency")String paymentCurrency,
                              @Param("remainingBalance")Double remainingBalance, @Param("remainingBalanceCurrency")String remainingBalanceCurrency,
                              @Param("patientName")String patientName);

}

