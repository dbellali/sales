package com.risf.service;

import java.util.List;
import java.util.Map;

import com.risf.model.Item;
import com.risf.model.Receipt;

public class ReceiptService {

    private static ReceiptService instance;
    private ItemService itemService;
    private TaxService taxService;

    private ReceiptService() {
        this.itemService = ItemService.getInstance();
        this.taxService = TaxService.getInstance();
    }

    public static ReceiptService getInstance() {
        if (instance == null) {
            instance = new ReceiptService();
        }
        return instance;
    }

    public void printReceiptInput(Receipt receipt) {
        List<Item> receiptItems = receipt.getItems();
        Map<Item, Long> groupedItems = this.itemService.groupItems(receiptItems);
        groupedItems.forEach(
                (item, count) -> System.out.println(count + " " + this.itemService.itemExludingTaxToString(item)));
    }

    public void printReceiptOutput(Receipt receipt) {
        List<Item> receiptItems = receipt.getItems();
        Map<Item, Long> groupedItems = this.itemService.groupItems(receiptItems);
        groupedItems.forEach(
                (item, count) -> System.out
                        .println(count + " " + this.itemService.groupedItemIncludingTaxToString(item, count)));
        this.printReceiptTotal(receiptItems);
    }

    public void printReceiptTotal(List<Item> items) {
        System.out.println("Sales Taxes: " +
                this.taxService.getSaleTax(items) +
                " Total: " +
                this.taxService.getTaxedPrice(items));
    }

    public void printReceiptTotal(Receipt receipt) {
        List<Item> items = receipt.getItems();
        this.printReceiptTotal(items);
    }
}
