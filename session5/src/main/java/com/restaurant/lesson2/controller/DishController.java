package com.restaurant.lesson2.controller;

import com.restaurant.lesson2.model.Dish;   // <-- import từ model
import com.restaurant.lesson2.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/lesson2/dishes")
    public String showDishList(Model model,
                               @RequestParam(value = "errorMessage", required = false) String errorMessage) {
        model.addAttribute("dishes", dishService.getAllDishes());
        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
        }
        return "dish-list";
    }

    @GetMapping("/lesson2/edit/{id}")
    public String editDish(@PathVariable int id, Model model) {
        Dish dish = dishService.findById(id);
        if (dish == null) {
            model.addAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            model.addAttribute("dishes", dishService.getAllDishes());
            return "dish-list";
        }
        model.addAttribute("dish", dish);
        return "edit-dish";
    }

    @PostMapping("/lesson2/edit/{id}")
    public String updateDish(@ModelAttribute Dish dish) {
        dishService.updateDish(dish);
        return "redirect:/lesson2/dishes";
    }
}