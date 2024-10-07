package com.microservice.factura.Infraestructure.Mappers.Implementations;

import com.microservice.factura.Domain.Models.Query.QueryBill;
import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.QueryBillMapper;
import org.springframework.stereotype.Component;

/**
 * this is the QueryBill mapper
 */
@Component
public class QueryBillMapperImpl implements QueryBillMapper<QueryBillEntity> {
    /**
     *
     * @param toDomain represents the jpa entity that needs to be mapper to a domain model (Query Bill)
     * @return QueryBill instance
     */
    @Override
    public QueryBill toDomain(QueryBillEntity toDomain) {
        return new QueryBill(toDomain.getRemainingBalanceCurrency(),toDomain.getPaymentCurrency(),toDomain.getTotalCurrency(),
                                toDomain.getPatientName(),toDomain.getPatientIdentification(),toDomain.getDentalProcedures());
    }
}
