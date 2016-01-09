package com.ream.www.maventest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by tong on 1/9/16.
 */
public class CheckFValidator implements ConstraintValidator<CheckF, String> {

    private long time;

    @Override
    public void initialize(CheckF constraintAnnotation) {
        this.time = constraintAnnotation.time();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value == null){
            return true;
        }
        if(time < 100){
            return true;
        }
        else{
            return false;
        }
    }
}
