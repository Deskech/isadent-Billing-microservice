package com.microservice.factura.Domain.Services;

/**
 * This service applies the currency format to the patient's bill
 * monetary values.
 */
public interface Currency {
    /**
     *
     * @param value the value needed to the formatted
     * @return the value but in a currency format
     */
    String format(Double value);
}
