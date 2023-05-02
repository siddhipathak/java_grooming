package com.example.q1.model;

import com.example.q1.enums.Category;

public class Product {
    private String id;
    private String name;
    private Boolean warranty;
    private Category category;

    public Product(String id, String name, Boolean warranty, Category category) {
        this.id = id;
        this.name = name;
        this.warranty = warranty;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getWarranty() {
        return warranty;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWarranty(Boolean warranty) {
        this.warranty = warranty;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", warranty=" + warranty + ", category=" + category + "]";
    }

}
