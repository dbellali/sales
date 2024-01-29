package com.risf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.risf.enumeration.TaxEnum;

public class ReceiptTest {

    @Test
    public void getItemsNotInitInConstructTest() {
        Receipt receipt = new Receipt();
        assertEquals(ArrayList.class, receipt.getItems().getClass());
        assertEquals(0, receipt.getItems().size());
    }

    @Test
    public void getItemsInitInConstructTest() {
        Category category1 = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category1);
        Item item2 = new Item("laptop", 299.99, category1);
        Item item3 = new Item("phone", 399.99, category1);
        List<Item> items = new ArrayList<Item>(List.of(item1, item2, item3));

        Receipt receipt = new Receipt(items);
        assertEquals(ArrayList.class, receipt.getItems().getClass());
        assertEquals(3, receipt.getItems().size());
        assertEquals(items, receipt.getItems());
    }

    @Test
    public void setItemsTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item11 = new Item("phone", 299.99, category);
        Item item12 = new Item("laptop", 299.99, category);
        Item item13 = new Item("phone", 399.99, category);
        List<Item> items1 = new ArrayList<Item>(List.of(item11, item12, item13));

        Item item21 = new Item("book", 9.99, category);
        Item item22 = new Item("parfum", 59.99, category);
        List<Item> items2 = new ArrayList<Item>(List.of(item21, item22));

        Receipt receipt = new Receipt(items1);
        assertEquals(ArrayList.class, receipt.getItems().getClass());
        assertEquals(3, receipt.getItems().size());
        assertEquals(items1, receipt.getItems());

        receipt.setItems(items2);
        assertEquals(ArrayList.class, receipt.getItems().getClass());
        assertEquals(2, receipt.getItems().size());
        assertEquals(items2, receipt.getItems());
    }

    @Test
    public void addListOfItemsTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item11 = new Item("phone", 299.99, category);
        Item item12 = new Item("laptop", 299.99, category);
        Item item13 = new Item("phone", 399.99, category);
        List<Item> items1 = new ArrayList<Item>(List.of(item11, item12, item13));

        Item item21 = new Item("book", 9.99, category);
        Item item22 = new Item("parfum", 59.99, category);
        List<Item> items2 = new ArrayList<Item>(List.of(item21, item22));

        Receipt receipt = new Receipt(items1);
        assertEquals(ArrayList.class, receipt.getItems().getClass());
        assertEquals(3, receipt.getItems().size());
        assertEquals(items1, receipt.getItems());

        receipt.addItem(items2);
        assertEquals(ArrayList.class, receipt.getItems().getClass());
        assertEquals(5, receipt.getItems().size());
        items1.addAll(items2);
        assertEquals(items1, receipt.getItems());
    }

    @Test
    public void addOneItemTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item11 = new Item("phone", 299.99, category);
        Item item12 = new Item("laptop", 299.99, category);
        Item item13 = new Item("phone", 399.99, category);
        List<Item> items1 = new ArrayList<Item>(List.of(item11, item12, item13));

        Item item21 = new Item("book", 9.99, category);

        Receipt receipt = new Receipt(items1);
        assertEquals(ArrayList.class, receipt.getItems().getClass());
        assertEquals(3, receipt.getItems().size());
        assertEquals(items1, receipt.getItems());

        receipt.addItem(item21);
        assertEquals(ArrayList.class, receipt.getItems().getClass());
        assertEquals(4, receipt.getItems().size());
        items1.add(item21);
        assertEquals(items1, receipt.getItems());
    }
}
