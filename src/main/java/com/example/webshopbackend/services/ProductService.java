package com.example.webshopbackend.services;

import com.example.webshopbackend.dto.DtoRequest;
import com.example.webshopbackend.enitites.Product;
import com.example.webshopbackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public Product updateUserById(int id, DtoRequest dtoRequest) {
        Product updateUser = productRepository.findById(id).orElseThrow();
        updateUser.setProductName(dtoRequest.productName());
        updateUser.setProductTitle(dtoRequest.productTitle());
        updateUser.setDescription(dtoRequest.description());
        updateUser.setPrice((long) dtoRequest.price());
        return productRepository.save(updateUser);
    }
}


