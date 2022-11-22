package com.example.webshopbackend.controller;

import com.example.webshopbackend.enitites.Product;
import com.example.webshopbackend.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")

public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product product(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();

    }




}
