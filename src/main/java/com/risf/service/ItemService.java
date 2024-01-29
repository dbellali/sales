package com.risf.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.risf.model.Item;

public class ItemService {

    private static final String IMPORTED_WORDING = "imported ";
    private static ItemService instance;

    private TaxService taxService;

    private ItemService() {
        this.taxService = TaxService.getInstance();
    }

    public static ItemService getInstance() {
        if (instance == null) {
            instance = new ItemService();
        }
        return instance;
    }

    public Map<Item, Long> groupItems(List<Item> items) {
        return items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
    }

    public String itemExludingTaxToString(Item item) {
        return this.getImportedWording(item.isImported()) + item.getName() + " at " + item.getPrice();
    }

    public String groupedItemIncludingTaxToString(Item item, Long itemsOcuurence) {
        return this.getImportedWording(item.isImported())
                + item.getName()
                + ": "
                + (taxService.getTaxedPrice(item) * itemsOcuurence);
    }

    private String getImportedWording(Boolean isImported) {
        return isImported ? IMPORTED_WORDING : "";
    }
}
