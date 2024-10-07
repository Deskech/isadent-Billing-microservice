package com.microservice.factura;

import com.microservice.factura.Application.Dtos.NewPaymentRequest;
import com.microservice.factura.Domain.Models.Query.QueryBillValues;
import com.microservice.factura.Domain.Repository.Query.QueryBillValuesRepository;
import com.microservice.factura.Domain.Services.NewPayment;
import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import com.microservice.factura.Infraestructure.Repository.Query.QueryValuesJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AlterarPaymentTest {
    @Autowired
    private NewPayment<NewPaymentRequest> newPayment;
    @Autowired
    private QueryBillValuesRepository queryBillValuesRepository;
    @Autowired
    private QueryValuesJpaRepository queryValuesJpaRepository;
    @Test
    public void mirar(){
        NewPaymentRequest newPaymentRequest = new NewPaymentRequest("jose manuel",900.00);
        newPayment.alterarAbono(newPaymentRequest);
    }

    @Test
    public void repository(){
        String nombrePaciente = "jose manuel";
        QueryBillValues queryBillValues = queryBillValuesRepository.getRestanteAndAbono(nombrePaciente);
        System.out.println(queryBillValues.getAbono());
    }
    @Test
    public void repositoryJpa(){
        String nombrePaciente = "jose manuel";
        QueryBillEntity queryFactura = queryValuesJpaRepository.getRemainingAndPayment(nombrePaciente);
        assertNotNull(queryFactura);
        System.out.println(queryFactura.getAbonoCurrency());
    }
}
