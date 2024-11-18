package com.crud.ProductDemo.repository;


import com.crud.ProductDemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
