package com.crud.ProductDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.crud.ProductDemo.models")  // Adjust package path if necessary
public class ProductDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDemoApplication.class, args);
	}

}
