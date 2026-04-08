package org.example.session04.bai3.service;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public String getOrderById(Long id) {
        return "Chi tiet don hang so " + id;
    }
}