package com.microservice.factura.Infraestructure.Mappers.Interfaces;

import com.microservice.factura.Domain.Models.Query.QueryBillValues;

/**
 *
 * Maps a jpa model to a domain model (QueryBillValues)
 */
public interface QueryValuesMapper<T> {
    /**
     *
     * @param toDomain represents the jpa model that needs to be a domain model
     * @return QueryBillValues instance
     */
    QueryBillValues toDomain(T toDomain);
}
