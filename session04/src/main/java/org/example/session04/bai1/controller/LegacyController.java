package org.example.session04.bai1.controller;

import org.example.session04.bai1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bai1/orders")
public class LegacyController {

    private OrderService orderService;
    @Autowired

    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
@ResponseBody
    public String getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/{id}")
@ResponseBody
    public String getOrderById(@PathVariable("id") Long id){
        return orderService.getOrderById(id);
    }
}
