package com.restaurant.lesson2.service;

import com.restaurant.lesson2.model.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {
    private final List<Dish> dishes = new ArrayList<>();

    public DishService() {
        dishes.add(new Dish(1, "Phở bò", 50000, true));
        dishes.add(new Dish(2, "Bún chả", 45000, false));
        dishes.add(new Dish(3, "Bánh mì", 20000, true));
    }

    public List<Dish> getAllDishes() {
        return dishes;
    }

    public Dish findById(int id) {
        return dishes.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateDish(Dish updatedDish) {
        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getId() == updatedDish.getId()) {
                dishes.set(i, updatedDish);
                break;
            }
        }
    }
}