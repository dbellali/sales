package com.risf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;

import com.risf.enumeration.TaxEnum;

public class ItemTest {

    @Test
    public void constructWith3ArgumentsTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 299.99, category);
        assertEquals(Item.class, item.getClass());
        assertFalse(item.isImported());
    }

    @Test
    public void constructWith4ArgumentsTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 299.99, category, true);
        assertEquals(Item.class, item.getClass());
        assertTrue(item.isImported());
    }

    @Test
    public void getNameTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 299.99, category);
        assertEquals("phone", item.getName());
    }

    @Test
    public void getPriceTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 299.99, category);
        assertEquals(299.99, item.getPrice());
    }

    @Test
    public void isImportedTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 299.99, category);
        assertFalse(item.isImported());
    }

    @Test
    public void getCategoryTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 299.99, category);
        assertEquals(Category.class, item.getCategory().getClass());
        assertEquals("other", item.getCategory().getName());
        assertEquals(TaxEnum.BASIC_TAX, item.getCategory().getTax());
    }

    @Test
    public void setNameTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 299.99, category);
        item.setName("laptop");
        assertEquals("laptop", item.getName());
    }

    @Test
    public void setPriceTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 299.99, category);
        item.setPrice(399.99);
        assertEquals(399.99, item.getPrice());
    }

    @Test
    public void setImportedTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item = new Item("phone", 299.99, category);
        item.setImported(true);
        assertTrue(item.isImported());
        item.setImported(false);
        assertFalse(item.isImported());
    }

    @Test
    public void setCategoryTest() {
        Category category1 = new Category("other", TaxEnum.BASIC_TAX);
        Category category2 = new Category("multimedia", TaxEnum.NO_TAX);
        Item item = new Item("book", 299.99, category1);
        assertEquals(Category.class, item.getCategory().getClass());
        assertEquals("other", item.getCategory().getName());
        assertEquals(TaxEnum.BASIC_TAX, item.getCategory().getTax());
        item.setCategory(category2);
        assertEquals(Category.class, item.getCategory().getClass());
        assertEquals("multimedia", item.getCategory().getName());
        assertEquals(TaxEnum.NO_TAX, item.getCategory().getTax());
    }

    @Test
    public void equalsTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category);
        Item item2 = new Item("phone", 299.99, category);
        assertTrue(item1.equals(item2));
    }

    @Test
    public void notEqualsNameTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category);
        Item item2 = new Item("laptop", 299.99, category);
        assertFalse(item1.equals(item2));
    }

    @Test
    public void notEqualsPriceTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category);
        Item item2 = new Item("phone", 399.99, category);
        assertFalse(item1.equals(item2));
    }

    @Test
    public void notEqualsCategoryTest() {
        Category category1 = new Category("other", TaxEnum.BASIC_TAX);
        Category category2 = new Category("multimedia", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category1);
        Item item2 = new Item("phone", 299.99, category2);
        assertFalse(item1.equals(item2));
    }

    @Test
    public void notEqualsImportedTest() {
        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category, true);
        Item item2 = new Item("phone", 399.99, category, false);
        assertFalse(item1.equals(item2));
    }

    @Test
    public void hashCodeTest() {
        Category category1 = new Category("other", TaxEnum.BASIC_TAX);
        Category category2 = new Category("multimedia", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category1);
        Item item2 = new Item("laptop", 299.99, category1);
        Item item3 = new Item("phone", 399.99, category1);
        Item item4 = new Item("phone", 299.99, category2);
        Item item5 = new Item("phone", 299.99, category2, true);

        int expectedHashcode1 = Objects.hash("phone", 299.99, false, category1);
        int expectedHashcode2 = Objects.hash("laptop", 299.99, false, category1);
        int expectedHashcode3 = Objects.hash("phone", 399.99, false, category1);
        int expectedHashcode4 = Objects.hash("phone", 299.99, false, category2);
        int expectedHashcode5 = Objects.hash("phone", 299.99, true, category2);

        assertEquals(expectedHashcode1, item1.hashCode());
        assertEquals(expectedHashcode2, item2.hashCode());
        assertEquals(expectedHashcode3, item3.hashCode());
        assertEquals(expectedHashcode4, item4.hashCode());
        assertEquals(expectedHashcode5, item5.hashCode());
    }
}
