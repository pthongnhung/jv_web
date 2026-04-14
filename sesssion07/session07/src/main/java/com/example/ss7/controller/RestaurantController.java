package com.example.ss7.controller;

import com.example.ss7.modal.RestaurantProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class RestaurantController {

    @GetMapping("/merchant/update-profile")
    public String showForm(Model model) {
        model.addAttribute("restaurantProfile", new RestaurantProfile());
        return "profile";
    }


    @PostMapping("/merchant/update-profile")
    public String updateProfile(RestaurantProfile restaurantProfile) {
        System.out.println("Tên quán: "+ restaurantProfile.getName());
        return "success";
    }
}
