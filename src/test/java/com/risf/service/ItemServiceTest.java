package com.risf.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.risf.enumeration.TaxEnum;
import com.risf.model.Category;
import com.risf.model.Item;

public class ItemServiceTest {

    @Test
    public void singltonTest() {
        ItemService itemService1 = ItemService.getInstance();
        ItemService itemService2 = ItemService.getInstance();
        assertEquals(true, itemService1 == itemService2);
    }

    @Test
    public void groupItems() {
        ItemService itemService = ItemService.getInstance();

        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category);
        Item item2 = new Item("phone", 299.99, category);
        Item item3 = new Item("phone", 299.99, category);
        Item item4 = new Item("book", 9.99, category);
        Item item5 = new Item("book", 9.99, category);
        Item item6 = new Item("chocolat", 19.99, category);
        List<Item> items = new ArrayList<Item>(List.of(item1, item2, item3, item4, item5, item6));
        Map<Item, Long> groupedItem = itemService.groupItems(items);

        Map<Item, Long> expectedGroupedItem = new HashMap<>();
        expectedGroupedItem.put(item1, Long.valueOf(3));
        expectedGroupedItem.put(item4, Long.valueOf(2));
        expectedGroupedItem.put(item6, Long.valueOf(1));
        assertEquals(groupedItem, expectedGroupedItem);
    }

    @Test
    public void itemExludingTaxToStringTest() {
        ItemService itemService = ItemService.getInstance();

        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category);
        Item item2 = new Item("phone", 299.99, category, true);

        String item1String = itemService.itemExludingTaxToString(item1);
        String expectedItem1String = "phone at 299.99";
        assertEquals(item1String, expectedItem1String);

        String item2String = itemService.itemExludingTaxToString(item2);
        String expectedItem2String = "imported phone at 299.99";
        assertEquals(item2String, expectedItem2String);
    }

    @Test
    public void groupedItemIncludingTaxToStringTest() {
        ItemService itemService = ItemService.getInstance();

        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category);
        Item item2 = new Item("phone", 299.99, category, true);

        String item1String = itemService.groupedItemIncludingTaxToString(item1, Long.valueOf(3));
        String expectedItem1String = "phone: 989.97";
        assertEquals(item1String, expectedItem1String);

        String item2String = itemService.groupedItemIncludingTaxToString(item2, Long.valueOf(3));
        String expectedItem2String = "imported phone: 1034.97";
        assertEquals(item2String, expectedItem2String);
    }

}
