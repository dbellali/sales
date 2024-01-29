package com.risf.enumeration;

public enum TaxEnum {

    BASIC_TAX(0.1),
    IMPORTED_TAX(0.05),
    NO_TAX(0.0);

    private final Double value;

    TaxEnum(final Double newValue) {
        value = newValue;
    }

    public Double getValue() {
        return value;
    }
}
