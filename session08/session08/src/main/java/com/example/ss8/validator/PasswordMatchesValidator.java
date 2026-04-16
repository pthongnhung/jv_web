package com.example.ss8.validator;

import com.example.ss8.annotation.PasswordMatches;
import com.example.ss8.dto.RegisterDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegisterDto> {

    @Override
    public boolean isValid(RegisterDto dto, ConstraintValidatorContext context) {
        if (dto.getPassword() == null || dto.getConfirmPassword() == null) {
            return false; // tránh NullPointerException
        }
        return dto.getPassword().equals(dto.getConfirmPassword());
    }
}
