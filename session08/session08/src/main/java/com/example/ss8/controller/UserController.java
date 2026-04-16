package com.example.ss8.controller;


import com.example.ss8.dto.PersonDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @PostMapping("/update")
    public ResponseEntity<String> updateAddress(@Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok("Cập nhật địa chỉ thành công");
    }
}
