package com.example.inventorybackend.controller;// OrderController.java

import com.example.inventorybackend.dto.PlacedOrder;
import com.example.inventorybackend.model.InventoryItem;
import com.example.inventorybackend.model.Order;
import com.example.inventorybackend.model.Product;
import com.example.inventorybackend.repository.InventoryRepository;
import com.example.inventorybackend.repository.OrderRepository;
import com.example.inventorybackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/place")
    public ResponseEntity<?> placeOrder(@RequestBody PlacedOrder o){
        System.out.println(o.getId());
        System.out.println(o.getQuantity());
        Optional<InventoryItem> optionalProduct = inventoryRepository.findById(o.getId());

        if(optionalProduct.isPresent())
        {
            InventoryItem i = optionalProduct.get();

            if(o.getQuantity() > i.getQuantity()){
                return new ResponseEntity<>("Insuffient stock", HttpStatus.OK);
            }

            i.setQuantity((i.getQuantity() - o.getQuantity()));
            inventoryRepository.save(i);
            return new ResponseEntity<>("placed", HttpStatus.OK);
        }
        return new ResponseEntity<>("not found", HttpStatus.OK);


        //            if (optionalProduct.isPresent()) {
//                Product product = optionalProduct.get();
//                int remainingQuantity = product.getQuantity() - order.getQuantity();
//
//                // Ensure that the remaining quantity doesn't go below zero
//                if (remainingQuantity < 0) {
//                    return ResponseEntity.badRequest().body("Not enough stock available for this product");
//                }
//
//                // Update the quantity of the product
//                product.setQuantity(remainingQuantity);
//
//                // If the remaining quantity is zero, you may choose to delete the product or mark it as out of stock
//                if (remainingQuantity == 0) {
//                    // Example: productRepository.delete(product);
//                    // Or mark it as out of stock: product.setOutOfStock(true);
//                }
//
//                // Save the updated product
//                productRepository.save(product);
//
//                // Save the order
//                orderRepository.save(order);
//
//                return ResponseEntity.ok("Order placed successfully!");
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error placing order: " + e.getMessage());
//        }
    }
//    @PostMapping("/api/orders")
//    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
//        try {
//            // Find the product by its ID
//            Optional<Product> optionalProduct = productRepository.findById(order.getProductId());
//            if (optionalProduct.isPresent()) {
//                Product product = optionalProduct.get();
//                int remainingQuantity = product.getQuantity() - order.getQuantity();
//
//                // Ensure that the remaining quantity doesn't go below zero
//                if (remainingQuantity < 0) {
//                    return ResponseEntity.badRequest().body("Not enough stock available for this product");
//                }
//
//                // Update the quantity of the product
//                product.setQuantity(remainingQuantity);
//
//                // If the remaining quantity is zero, you may choose to delete the product or mark it as out of stock
//                if (remainingQuantity == 0) {
//                    // Example: productRepository.delete(product);
//                    // Or mark it as out of stock: product.setOutOfStock(true);
//                }
//
//                // Save the updated product
//                productRepository.save(product);
//
//                // Save the order
//                orderRepository.save(order);
//
//                return ResponseEntity.ok("Order placed successfully!");
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error placing order: " + e.getMessage());
//        }
//    }
}
