package com.risf.enumeration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaxEnumTest {

    @Test
    public void basicTaxTest() {
        TaxEnum taxEnum = TaxEnum.BASIC_TAX;
        assertEquals(0.1, taxEnum.getValue());
    }

    @Test
    public void importedTaxTest() {
        TaxEnum taxEnum = TaxEnum.IMPORTED_TAX;
        assertEquals(0.05, taxEnum.getValue());
    }

    @Test
    public void noTaxTest() {
        TaxEnum taxEnum = TaxEnum.NO_TAX;
        assertEquals(0.0, taxEnum.getValue());
    }

}
