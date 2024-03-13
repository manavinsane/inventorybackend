package com.example.inventorybackend.service;

import com.example.inventorybackend.model.InventoryItem;
import com.example.inventorybackend.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public InventoryItem addInventoryItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }

    @Override
    public InventoryItem updateInventoryItem(Long id, InventoryItem updatedItem) {
        if (inventoryRepository.existsById(id)) {
            updatedItem.setId(id); // Set the ID of the updated item
            return inventoryRepository.save(updatedItem);
        } else {
            throw new RuntimeException("Inventory item not found with ID: " + id);
        }
    }
    @Override
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }
    @Override
    public void removeInventoryItem(Long id) {
        if (inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Inventory item not found with ID: " + id);
        }
    }
}
