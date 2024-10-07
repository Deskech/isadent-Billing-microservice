package com.microservice.factura;

import com.microservice.factura.Domain.Models.Query.QueryBill;
import com.microservice.factura.Domain.Repository.Query.QueryBillRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InterfaceTest {
    @Autowired
    private QueryBillRepository queryBillRepository;

    @Test
    public void testInterface(){
        String  nombrePaciente = "jose manuel";
      QueryBill queryBillEntity = queryBillRepository.showBill(nombrePaciente);
      System.out.print(queryBillEntity.getPaymentCurrency());
        System.out.print(queryBillEntity.getNombrePaciente());
        System.out.print(nombrePaciente);

    }
}
