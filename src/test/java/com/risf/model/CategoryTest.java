package com.risf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.risf.enumeration.TaxEnum;

public class CategoryTest {

    @Test
    public void getNameTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        assertEquals("other", category.getName());
    }

    @Test
    public void getTaxTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        assertEquals(TaxEnum.BASIC_TAX, category.getTax());
    }

    @Test
    public void setNameTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        category.setName("multimedia");
        assertEquals("multimedia", category.getName());
    }

    @Test
    public void setTaxTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        category.setTax(TaxEnum.NO_TAX);
        assertEquals(TaxEnum.NO_TAX, category.getTax());
    }

}
