package com.aluracurso.conversorMoneda.model;

import java.util.Map;

public class Cambios {
    private String base_code;
    private Map<String, Double> conversion_rates;
    public String getBaseCode() {
        return base_code;
    }

    public void setBaseCode(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public void setConversionRates(Map<String, Double> conversionRates) {
        this.conversion_rates = conversionRates;
    }
    public double getPrecioMoneda(String moneda) {
        if (conversion_rates.containsKey(moneda)) {
            return conversion_rates.get(moneda);
        } else {
            throw new IllegalArgumentException("La moneda especificada no está disponible en la lista de conversiones.");
        }
    }
    @Override
    public String toString() {
        return base_code ;
    }
}
