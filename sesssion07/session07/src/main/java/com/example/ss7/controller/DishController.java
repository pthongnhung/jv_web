package com.example.ss7.controller;

import com.example.ss7.modal.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/dish")
public class DishController {

    // Tự động thêm "categories" vào model cho mọi request trong controller này
    @ModelAttribute("categories")
    public List<String> categories() {
        return Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
    }

    // API 1: Mở form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish/dish-add";
    }

    // API 2: Mở form chỉnh sửa
    @GetMapping("/edit")
    public String showEditForm(Model model) {
        model.addAttribute("dish", new Dish("Trà sữa", "Đồ uống"));
        return "dish/dish-edit";
    }

    // API 3: Mở trang tìm kiếm
    @GetMapping("/search")
    public String showSearchPage() {
        return "dish/dish-search";
    }
    @PostMapping("/add")
    public String saveDish(@ModelAttribute Dish dish) {
        // In ra console để kiểm tra dữ liệu nhận được
        System.out.println("Tên món: " + dish.getName());
        System.out.println("Nhóm món: " + dish.getCategory());

        // Sau khi lưu, có thể chuyển hướng về trang tìm kiếm hoặc form
        return "redirect:/dish/search";
    }

}
