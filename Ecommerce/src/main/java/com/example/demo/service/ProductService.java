package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
   
	@Autowired
	private ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepo.findById(id).orElseThrow();
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Integer id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        product.setCategory(productDetails.getCategory());
        return productRepo.save(product);
    }

    public void deleteProduct(Integer id) {
    	productRepo.deleteById(id);
    }
}

