package com.example.ss8.controller;


import com.example.ss8.dto.EmployeeDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmploieeController {

    @GetMapping("/hr/add-employee")
    public String showForm(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "employee-form";
    }

    @PostMapping("/hr/add-employee")
    public String saveEmployee(@Valid @ModelAttribute("employee")EmployeeDto employee , BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "employee-form";
        }
        return "redirect:/hr/success";
    }
}
