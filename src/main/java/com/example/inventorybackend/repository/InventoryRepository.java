package com.example.inventorybackend.repository;

import com.example.inventorybackend.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    // Custom repository methods (if any)
    @Query("SELECT i FROM InventoryItem i WHERE i.productName = :name")
    InventoryItem findByName(@Param("name") String name);
}
