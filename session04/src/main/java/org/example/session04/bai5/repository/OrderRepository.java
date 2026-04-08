package org.example.session04.bai5.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public String getOrderById(Long id) {
        return "Thong tin don hang so " + id;
    }

    public String createOrder() {
        return "Tao don hang thanh cong";
    }

    public String deleteOrder(Long id) {
        return "Da huy don hang so " + id;
    }
}