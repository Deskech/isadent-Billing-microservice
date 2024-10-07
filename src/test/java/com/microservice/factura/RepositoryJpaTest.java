package com.microservice.factura;

import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import com.microservice.factura.Infraestructure.Repository.Query.QueryBillJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RepositoryJpaTest {
    @Autowired
    private QueryBillJpaRepository queryBillJpaRepository;

    @Test
    public void mostrarFactura(){
        String nombre = "jose manuel";
       QueryBillEntity queryBillEntity =  queryBillJpaRepository.showBill(nombre);
       System.out.println(nombre);
        System.out.println(queryBillEntity.getNombrePaciente());
        System.out.println(queryBillEntity.getFacturaId());
        assertNotNull(queryBillEntity);
        assertEquals("jose manuel", queryBillEntity.getNombrePaciente());
    }
}
