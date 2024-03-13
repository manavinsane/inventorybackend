package com.example.inventorybackend.dto;

public class Item {
    private String productName;
    private int quantity;

    public Item(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public Item() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
