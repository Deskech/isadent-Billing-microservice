package com.microservice.factura.Infraestructure.Persistance.Query;


import com.microservice.factura.Domain.Models.Query.QueryBill;
import com.microservice.factura.Domain.Repository.Query.QueryBillRepository;
import com.microservice.factura.Infraestructure.Entity.Query.QueryBillEntity;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.QueryBillMapper;
import com.microservice.factura.Infraestructure.Repository.Query.QueryBillJpaRepository;
import org.springframework.stereotype.Component;

/**
 * this is the QueryBill domain repository implementation
 */
@Component
public class QueryBillRepositoryImpl implements QueryBillRepository {
    private final QueryBillJpaRepository queryBillJpaRepository;
    private final QueryBillMapper<QueryBillEntity> queryBillMapper;
    public QueryBillRepositoryImpl(QueryBillJpaRepository queryBillJpaRepository, QueryBillMapper<QueryBillEntity> queryBillMapper){
        this.queryBillJpaRepository = queryBillJpaRepository;
        this.queryBillMapper = queryBillMapper;
    }

    /**
     *
     * @param patientName represents the patient's name needed to see the bill
     * @return QueryBill instance ( formatted bill's presentation )
     */
    @Override
    public QueryBill showBill(String patientName) {
           QueryBillEntity queryBillEntity = queryBillJpaRepository.showBill(patientName);
           System.out.print(patientName);
           System.out.println(queryBillEntity.getBillId());
           return queryBillMapper.toDomain(queryBillEntity);
    }
}
