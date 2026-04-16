package com.example.ss8.validator;

import com.example.ss8.annotation.MultipleOfTenThousand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfTenThousandValidator implements ConstraintValidator<MultipleOfTenThousand, Long> {
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext){
        if (value ==null) {
            return false;
        }
        if (value < 50000) {
            return false;
        }
        if (value % 100000!=0) {
            return false;
        }
        return true;
    }

}
