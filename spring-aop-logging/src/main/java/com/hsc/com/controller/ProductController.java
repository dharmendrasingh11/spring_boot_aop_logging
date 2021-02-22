package com.hsc.com.controller;

import com.hsc.com.model.Product;
import com.hsc.com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/save")
    public List<Product> saveProduct(@RequestBody List<Product> productList){
        return productService.addProduct(productList);
    }

    @GetMapping("/findAllProduct")
    public List<Product> getProduct(){

        return productService.findAllProduct();
    }
}
