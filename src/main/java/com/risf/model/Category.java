package com.risf.model;

import com.risf.enumeration.TaxEnum;

public class Category {

    private String name;
    private TaxEnum tax;

    public Category(String name, TaxEnum tax) {
        this.name = name;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaxEnum getTax() {
        return tax;
    }

    public void setTax(TaxEnum tax) {
        this.tax = tax;
    }

}
