package com.microservice.factura.Infraestructure.Services;


import com.microservice.factura.Application.Dtos.CacheUpdatedValues;
import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * This service is responsible for updating the cache when a new payment is registered
 */
@Service
public class CacheBillValues {

    private final RedisTemplate<String,CacheUpdatedValues> redisTemplate;

    public CacheBillValues(RedisTemplate<String,CacheUpdatedValues> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     *
     * @param billValues represents the patient's name monetary values
     * @param patientName the patient's name
     */
    public void updateCache(BillValues billValues, String patientName ){
        CacheUpdatedValues cacheUpdatedValues = new CacheUpdatedValues(billValues.getRemainingBalanceCurrency(),
                billValues.getTotalCurrency(), patientName, billValues.getPaymentCurrency()
        );
        String cacheKey = "BillValues::" + patientName;
        redisTemplate.opsForValue().set(cacheKey,cacheUpdatedValues,15, TimeUnit.SECONDS);

    }

    /**
     *
     * @param patientName the patient's name
     * @return a new instance of CacheUpdatedValues loaded from the cache
     */
    public CacheUpdatedValues getCache(String patientName){
        String cacheKey = "BillValues::" + patientName;
       return  redisTemplate.opsForValue().get(cacheKey);
    }

}
