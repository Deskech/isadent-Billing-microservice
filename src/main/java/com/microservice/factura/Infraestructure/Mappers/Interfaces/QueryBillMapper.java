package com.microservice.factura.Infraestructure.Mappers.Interfaces;

import com.microservice.factura.Domain.Models.Query.QueryBill;

/**
 *Maps a jpa model to a domain model (QueryBill)
 */
public interface QueryBillMapper<T> {
    /**
     *
     * @param toDomain represents the jpa model we want to map as a domain object
     * @return QueryBill instance
     */
    QueryBill toDomain(T toDomain);
}
