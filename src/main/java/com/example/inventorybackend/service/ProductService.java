package com.example.inventorybackend.service;

import com.example.inventorybackend.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);

    // New method for updating product quantity
    Product updateProductQuantity(Long productId, int quantity);
}
