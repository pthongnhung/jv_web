package org.example.session04.bai4.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    public String getProducts(String category, int limit) {
        return "Danh sach " + limit + " mon thuoc loai: " + category;
    }
}