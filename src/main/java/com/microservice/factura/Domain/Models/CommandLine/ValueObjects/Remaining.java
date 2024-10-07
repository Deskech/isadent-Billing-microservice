package com.microservice.factura.Domain.Models.CommandLine.ValueObjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
/**
* Represents the remaining balance that the patient has to pay.
* this object is inmutable and its value is calculated
  in relation with the total
* */
@Getter
@EqualsAndHashCode

public final class Remaining {
 private final Double remainingPayment;

 public Remaining(Double remainingPayment){
     this.remainingPayment = remainingPayment;
 }
}
