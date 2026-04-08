package org.example.session04.bai4.service;

import org.example.session04.bai4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getProducts(String category, int limit) {
        return productRepository.getProducts(category, limit);
    }
}