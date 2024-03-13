package com.example.inventorybackend.service;

import com.example.inventorybackend.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InventoryService {
    InventoryItem addInventoryItem(InventoryItem item);
    InventoryItem updateInventoryItem(Long id, InventoryItem updatedItem);
    void removeInventoryItem(Long id);

    List<InventoryItem> getAllInventoryItems();

}
