package com.risf.service;

import java.util.List;

import com.risf.enumeration.TaxEnum;
import com.risf.model.Item;
import com.risf.utils.Rounding;

public class TaxService {

    private static TaxService instance;
    public static final Double ROUNDING_VALUE = 0.05;

    private TaxService() {
    }

    public static TaxService getInstance() {
        if (instance == null) {
            instance = new TaxService();
        }
        return instance;
    }

    public Double getSaleTax(Double tax, Double price) {
        return Rounding.getRoundingValue(tax * price, ROUNDING_VALUE);
    }

    public Double getSaleTax(Item item) {
        Double tax = item.getCategory().getTax().getValue();
        Double price = item.getPrice();
        Double importedTax = item.isImported() ? TaxEnum.IMPORTED_TAX.getValue() : TaxEnum.NO_TAX.getValue();
        Double totalTaxe = tax + importedTax;
        Double saleTax = this.getSaleTax(totalTaxe, price);
        return Rounding.scaleDouble(saleTax);
    }

    public Double getSaleTax(List<Item> items) {
        Double salesTaxs = 0.0;
        for (Item item : items) {
            salesTaxs += this.getSaleTax(item);
        }
        return Rounding.scaleDouble(salesTaxs);
    }

    public Double getTaxedPrice(Item item) {
        Double taxdPrice = item.getPrice() + getSaleTax(item);
        return Rounding.scaleDouble(taxdPrice);
    }

    public Double getTaxedPrice(List<Item> items) {
        Double total = 0.0;
        for (Item item : items) {
            total += this.getTaxedPrice(item);
        }
        return Rounding.scaleDouble(total);
    }
}
