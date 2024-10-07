package com.microservice.factura.Infraestructure.Mappers.Implementations;

import com.microservice.factura.Domain.Models.Query.QueryBillValues;
import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.QueryValuesMapper;
import org.springframework.stereotype.Component;

/**
 * this is the QueryValues mapper
 */
@Component
public class QueryValuesMapperImpl implements QueryValuesMapper<QueryBillEntity> {
    /**
     *
     * @param toDomain represents the Jpa entity that need to be mapper to a domain model ( QueryBillValues)
     * @return QueryBillValues instance
     */
    @Override
    public QueryBillValues toDomain(QueryBillEntity toDomain) {
        return new QueryBillValues(toDomain.getPayment(), toDomain.getRemainingBalance(), toDomain.getTotal());
    }
}
