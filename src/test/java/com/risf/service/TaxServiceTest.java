package com.risf.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.risf.enumeration.TaxEnum;
import com.risf.model.Category;
import com.risf.model.Item;

public class TaxServiceTest {

    @Test
    public void singltonTest() {
        TaxService taxService1 = TaxService.getInstance();
        TaxService taxService2 = TaxService.getInstance();
        assertEquals(true, taxService1 == taxService2);
    }

    @Test
    public void getSaleTaxByTaxAndPriceTest() {
        TaxService taxService = TaxService.getInstance();
        Double tax1 = TaxEnum.BASIC_TAX.getValue();
        Double tax2 = TaxEnum.IMPORTED_TAX.getValue();
        Double tax3 = TaxEnum.NO_TAX.getValue();
        Double price = 9.99;

        assertEquals(1.0, taxService.getSaleTax(tax1, price));
        assertEquals(0.5, taxService.getSaleTax(tax2, price));
        assertEquals(0.0, taxService.getSaleTax(tax3, price));
    }

    @Test
    public void getSaleTaxByItemTest() {
        TaxService taxService = TaxService.getInstance();
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 9.99, category, true);
        assertEquals(1.5, taxService.getSaleTax(item));
        item.setImported(false);
        assertEquals(1.0, taxService.getSaleTax(item));

        category.setTax(TaxEnum.IMPORTED_TAX);
        assertEquals(0.5, taxService.getSaleTax(item));

        category.setTax(TaxEnum.NO_TAX);
        assertEquals(0.0, taxService.getSaleTax(item));
    }

    @Test
    public void getSaleTaxByItemsTest() {
        TaxService taxService = TaxService.getInstance();
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 9.99, category);
        Item item2 = new Item("phone", 9.99, category);
        Item item3 = new Item("phone", 9.99, category);
        List<Item> items = new ArrayList<Item>(List.of(item1, item2, item3));
        assertEquals(3.0, taxService.getSaleTax(items));

        category.setTax(TaxEnum.IMPORTED_TAX);
        assertEquals(1.5, taxService.getSaleTax(items));

        category.setTax(TaxEnum.NO_TAX);
        assertEquals(0.0, taxService.getSaleTax(items));
    }

    @Test
    public void getTaxedPriceByItemTest() {
        TaxService taxService = TaxService.getInstance();
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 9.99, category, true);
        assertEquals(11.49, taxService.getTaxedPrice(item));
        item.setImported(false);
        assertEquals(10.99, taxService.getTaxedPrice(item));

        category.setTax(TaxEnum.IMPORTED_TAX);
        assertEquals(10.49, taxService.getTaxedPrice(item));

        category.setTax(TaxEnum.NO_TAX);
        assertEquals(9.99, taxService.getTaxedPrice(item));
    }

    @Test
    public void getTaxedPriceByItemsTest() {
        TaxService taxService = TaxService.getInstance();
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 9.99, category);
        Item item2 = new Item("phone", 9.99, category);
        Item item3 = new Item("phone", 9.99, category);
        List<Item> items = new ArrayList<Item>(List.of(item1, item2, item3));
        assertEquals(32.97, taxService.getTaxedPrice(items));

        category.setTax(TaxEnum.IMPORTED_TAX);
        assertEquals(31.47, taxService.getTaxedPrice(items));

        category.setTax(TaxEnum.NO_TAX);
        assertEquals(29.97, taxService.getTaxedPrice(items));
    }

}
