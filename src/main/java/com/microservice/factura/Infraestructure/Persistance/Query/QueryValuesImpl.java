package com.microservice.factura.Infraestructure.Persistance.Query;

import com.microservice.factura.Domain.Models.Query.QueryBillValues;
import com.microservice.factura.Domain.Repository.Query.QueryBillValuesRepository;
import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.QueryValuesMapper;
import com.microservice.factura.Infraestructure.Repository.Query.QueryValuesJpaRepository;
import org.springframework.stereotype.Component;

/**
 * this is the QueryBillValues domain repository
 */
@Component
public class QueryValuesImpl implements QueryBillValuesRepository {
    private final QueryValuesJpaRepository queryValuesJpaRepository;
    private final QueryValuesMapper<QueryBillEntity> queryValuesMapper;
    public QueryValuesImpl(QueryValuesJpaRepository queryValuesJpaRepository, QueryValuesMapper<QueryBillEntity> queryValuesMapper){
        this.queryValuesMapper = queryValuesMapper;
        this.queryValuesJpaRepository = queryValuesJpaRepository;
    }

    /**
     *
     * @param patientName that did a new Payment
     * @return the mapped version of the remaining payment and the last payment
     */
    @Override
    public QueryBillValues getRemainingAndPayment(String patientName) {
        return queryValuesMapper.toDomain(queryValuesJpaRepository.getRemainingAndPayment(patientName));
    }
}
