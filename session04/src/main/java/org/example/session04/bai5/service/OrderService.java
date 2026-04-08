package org.example.session04.bai5.service;

import org.example.session04.bai5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    public String createOrder() {
        return orderRepository.createOrder();
    }

    public String deleteOrder(Long id) {
        return orderRepository.deleteOrder(id);
    }
}