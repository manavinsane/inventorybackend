package com.example.inventorybackend.controller;

import com.example.inventorybackend.dto.Item;
import com.example.inventorybackend.model.InventoryItem;
import com.example.inventorybackend.repository.InventoryRepository;
import com.example.inventorybackend.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping
    public InventoryItem addInventoryItem(@RequestBody Item i) {
        InventoryItem item = inventoryRepository.findByName(i.getProductName());
        if(item == null){
            InventoryItem obj = new InventoryItem();
            obj.setQuantity(i.getQuantity());
            obj.setProductName(i.getProductName());
            inventoryRepository.save(obj);
            return obj;
        }else{
            item.setQuantity(item.getQuantity() + i.getQuantity());
            inventoryRepository.save(item);
            return item;
        }
    }
    @PutMapping("/{id}")
    public InventoryItem updateInventoryItem(@PathVariable Long id, @RequestBody InventoryItem updatedItem) {
        return inventoryService.updateInventoryItem(id, updatedItem);
    }

    @GetMapping
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryService.getAllInventoryItems();
    }

    @DeleteMapping("/{id}")
    public void removeInventoryItem(@PathVariable Long id) {
        inventoryService.removeInventoryItem(id);
    }
}

//inventory and product synced
