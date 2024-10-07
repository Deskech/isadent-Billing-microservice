package com.microservice.factura.Infraestructure.Mappers.Interfaces;

import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;

/**
 * Maps a bill values string back to a class
 */
public interface BillValuesMapper {
    /**
     *
     * @param billValuesString represents the same value but as a string
     * @return BillValues instance
     */
    BillValues toClass(String billValuesString);
}
