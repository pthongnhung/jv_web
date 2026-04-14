package com.example.ss7.controller;

import com.example.ss7.modal.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    private static List<Food> foods = new ArrayList<>();

    @ModelAttribute("categories")
    public List<String> categories() {
        return Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
    }

    @GetMapping("/add")
    public String showAddPage(Model model) {
        model.addAttribute("food", new Food());
        return "food/food-add";
    }

    @PostMapping("/add")
    public String saveFood(@ModelAttribute Food food,
                           @RequestParam("image") MultipartFile file,
                           RedirectAttributes redirectAttributes) throws IOException {

        String path = "D:/java-210/210B/src/main/java/SS7/ss7/src/main/webapp/WEB-INF/images/";

        if (file.isEmpty()) {
            throw new RuntimeException("Phải đính kèm ảnh");
        }

        if (file.getSize() > 2 * 1024 * 1024) {
            throw new RuntimeException("File quá lớn, tối đa 2MB");
        }

        String originalName = file.getOriginalFilename();
        if (originalName == null || !(originalName.endsWith(".jpg") || originalName.endsWith(".jpeg") || originalName.endsWith(".png"))) {
            throw new RuntimeException("Chỉ chấp nhận file ảnh (.jpg, .jpeg, .png)");
        }

        if (food.getPrice() < 0) {
            throw new RuntimeException("Giá tiền phải >= 0");
        }

        // Sinh tên duy nhất
        String uniqueName = System.currentTimeMillis() + "_" + originalName;
        // hoặc dùng UUID: String uniqueName = UUID.randomUUID().toString() + "_" + originalName;

        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File dest = new File(path + uniqueName);
        file.transferTo(dest);

        food.setImagePath(uniqueName); // lưu tên file duy nhất
        foods.add(food);

        System.out.println("Đã thêm món: " + food.getName() + " - " + food.getCategory() + " - " + food.getPrice());
        System.out.println("Tổng số món hiện có: " + foods.size());

        // Truyền food sang trang detail
        redirectAttributes.addFlashAttribute("food", food);
        return "redirect:/food/detail";
    }
    @GetMapping("/detail")
    public String showDetailPage(Model model) {
        Food food = (Food) model.getAttribute("food");
        model.addAttribute("food", food);
        return "food/food-detail";
    }

}
