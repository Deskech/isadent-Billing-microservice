package com.microservice.factura.Infraestructure.Mappers.Interfaces;

import java.util.List;

/**
 * Maps a list of dental procedures and prices into a json (String)
 */
public interface DentalProceduresMapper<T>{
    /**
     *
     * @param dentalProcedures represents the list of dental procedures and prices
     * @return a string object
     */
    String toJson(List<T> dentalProcedures);
}
