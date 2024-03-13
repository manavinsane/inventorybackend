package com.example.inventorybackend.service;

import com.example.inventorybackend.model.Product;
import com.example.inventorybackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProductQuantity(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            int updatedQuantity = product.getQuantity() - quantity;
            if (updatedQuantity < 0) {
                throw new IllegalArgumentException("Not enough stock available for this product");
            }
            product.setQuantity(updatedQuantity);
            return productRepository.save(product);
        }
        return null;
    }
}
