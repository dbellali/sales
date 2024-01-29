package com.risf.model;

import java.util.Objects;

public class Item {

    private String name;
    private Double price;
    private Category category;
    private Boolean imported = false;

    public Item(String name, Double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Item(String name, Double price, Category category, Boolean imported) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.imported = imported;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean isImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Item item = (Item) obj;
        return Objects.equals(this.getName(), item.getName()) &&
                Objects.equals(this.getPrice(), item.getPrice()) &&
                Objects.equals(this.isImported(), item.isImported()) &&
                Objects.equals(this.getCategory(), item.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getPrice(), this.isImported(), this.getCategory());
    }

}
