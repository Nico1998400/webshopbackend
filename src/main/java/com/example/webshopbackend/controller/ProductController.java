package com.example.webshopbackend.controller;

import com.example.webshopbackend.dto.DtoRequest;
import com.example.webshopbackend.enitites.Product;
import com.example.webshopbackend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public Product product(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product changeProductById(
            @PathVariable int id,
            @RequestBody DtoRequest product) {
        return productService.updateUserById(id, product);
    }
}



