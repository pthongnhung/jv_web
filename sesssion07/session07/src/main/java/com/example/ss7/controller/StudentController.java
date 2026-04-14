package com.example.ss7.controller;

import com.example.ss7.modal.Student;
import com.example.ss7.reposotory.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("students",studentRepo.getStudents());
        return "home";
    }

}
