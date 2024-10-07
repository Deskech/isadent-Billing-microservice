package com.microservice.factura.Domain.Repository.Query;

import com.microservice.factura.Domain.Models.Query.QueryBill;
/**
 *Represents the view of the patient's bill that is in the database
 *
 */

public interface QueryBillRepository {
    /**
     * @params patientName
     * @return formatted view of the patient's bill
     */

    QueryBill showBill(String patientName);
}
