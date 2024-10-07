package com.microservice.factura.Infraestructure.Mappers.Interfaces;

import com.microservice.factura.Application.Dtos.NewPaymentRequest;

/**
 * Maps a NewPaymentRequest String back to class
 */
public interface NewPaymentReqMapper {
    /**
     *
     * @param newPaymentRequest representation of newPaymentRequestObject but String
     * @return NewPaymentRequest instance
     */
    NewPaymentRequest crear(String newPaymentRequest);
}
