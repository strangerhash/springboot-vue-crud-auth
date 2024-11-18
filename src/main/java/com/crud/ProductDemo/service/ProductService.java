package com.crud.ProductDemo.service;


import com.crud.ProductDemo.models.Product;
import com.crud.ProductDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Discount logic: if more than 5 products, apply 5% discount
    public Double calculateDiscount(List<Product> products) {
        if (products.size() > 5) {
            return products.stream().mapToDouble(Product::getPrice).sum() * 0.95; // 5% discount
        }
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
