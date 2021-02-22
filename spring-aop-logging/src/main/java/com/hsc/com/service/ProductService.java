package com.hsc.com.service;

import com.hsc.com.model.Product;
import com.hsc.com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> addProduct(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}
