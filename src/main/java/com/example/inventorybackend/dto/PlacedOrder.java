package com.example.inventorybackend.dto;

public class PlacedOrder {
    private Long id;
    private int quantity;

    public PlacedOrder(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public PlacedOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
