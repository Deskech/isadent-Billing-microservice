package com.microservice.factura.Infraestructure.Services;

import com.microservice.factura.Domain.Services.Currency;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This is the currency service implementation
 */
@Component
public class CurrencyImpl implements Currency {
private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     *
     * @param value the value needed to the formatted
     * @return money formatted value
     */
    @Override
    public String format(Double value) {
        return numberFormat.format(value);
    }
}
