package com.microservice.factura.Infraestructure.Mappers.Interfaces;

import com.microservice.factura.Infraestructure.Events.Publicado.Dtos.PaymentPublishedEvent;

/**
 * Maps a string object back to class
 */
public interface PublishedPaymentMapper {
   /**
    *
    * @param publishedPayment represents the string object of paymentPublishedEvent
    * @return PaymentPublishedEvent instance
    */
   PaymentPublishedEvent create(String publishedPayment);
}
