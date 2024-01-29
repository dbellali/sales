package com.risf.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Item> items;

    public Receipt() {
        this.items = new ArrayList<>();
    }

    public Receipt(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(List<Item> items) {
        this.items.addAll(items);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
