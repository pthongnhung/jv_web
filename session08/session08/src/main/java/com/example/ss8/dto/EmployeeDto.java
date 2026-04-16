package com.example.ss8.dto;

import jakarta.validation.constraints.*;

public class EmployeeDto {

    @NotBlank(message = "Tên nhân viên không được để trống")
    private String name;

    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    @Max(value = 60, message = "Tuổi không được quá 60")
    private int age;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    private String email;

    // getters và setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
