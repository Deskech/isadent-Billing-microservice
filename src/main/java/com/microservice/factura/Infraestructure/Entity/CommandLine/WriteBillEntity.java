package com.microservice.factura.Infraestructure.Entity.CommandLine;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the jpa entity for the Command line database
 */
@Entity
@Getter
@Setter
@Table(name = "writeFacturas")
public class WriteBillEntity {
    @Id
    @Column(name = "factura_id")
    private String billId;

    @Column(name = "nombre_paciente")
    private String patientName;
    @Column(name="cedula_paciente")
    private String patientIdentification;
    @Column(name = "direccion_paciente")
    private String patientDirection;

    @Lob
    @Column(name = "procedimientos")
    private String dentalProcedures;

    @Column(name = "abono")
    private Double payment;
    @Column(name = "total")
    private Double total;
    @Column(name = "restante")
    private Double remainingBalance;
    @Column(name = "abonoCurrency")
    private String paymentCurrency;
    @Column(name = "totalCurrency")
    private String totalCurrency;
    @Column(name = "restanteCurrency")
    private String remainingBalanceCurrency;
}
