package com.microservice.factura.Domain.Repository.CommandLine;

import com.microservice.factura.Domain.Models.CommandLine.Aggregates.BillValues;
/**Represents the persistence of the domain aggregates.*/
public interface BillValuesRepository {
    /**Saves the new Bill values for a firts time patient.
    * This method must be used only if a new Quotation request is entered.
    * @params billValues comming from the Quotation object and a patientName. Must not be null
    * */
    void saveBillValues(BillValues billValues, String patientName);
    /**Updates current the patient's bill monetary values.
    *This method must be used only if a new payment is set.
    * @params billValue instance created by new calculations, and the patientsName
    * */
    void updateBillValues(BillValues billValues, String patientName);

}
