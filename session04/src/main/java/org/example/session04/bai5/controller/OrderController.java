package org.example.session04.bai5.controller;

import org.example.session04.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bai5/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //  1. Xem đơn hàng
    @GetMapping("/{id}")
    public String getOrder(@PathVariable String id) {
        try {
            Long orderId = Long.parseLong(id);
            return orderService.getOrderById(orderId);
        } catch (Exception e) {
            return "ID don hang phai la mot so";
        }
    }

    // 2. Tạo đơn hàng
    @PostMapping
    public String createOrder() {
        return orderService.createOrder();
    }

    // 3. Hủy đơn hàng
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}