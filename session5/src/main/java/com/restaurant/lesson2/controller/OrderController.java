package com.restaurant.lesson2.controller;

import com.restaurant.lesson2.model.Dish;
import com.restaurant.lesson2.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    private final DishService dishService;

    @Autowired
    public OrderController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/lesson2/order")
    public String showOrderPage(Model model) {
        model.addAttribute("dishes", dishService.getAllDishes());
        return "smart-order";
    }

    @PostMapping("/lesson2/order")
    public String submitOrder(@RequestParam List<Integer> dishIds, Model model) {
        List<Dish> selected = dishService.getAllDishes().stream()
                .filter(d -> dishIds.contains(d.getId()))
                .toList();
        double total = selected.stream().mapToDouble(Dish::getPrice).sum();

        model.addAttribute("selectedDishes", selected);
        model.addAttribute("total", total);
        return "order-summary";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Model model) {
        model.addAttribute("errorMessage", "Có lỗi xảy ra hoặc truy cập không hợp lệ!");
        model.addAttribute("dishes", dishService.getAllDishes());
        return "smart-order";
    }
}