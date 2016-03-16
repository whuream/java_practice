package com.ream.www.maventest.constraintValidator;

import com.ream.www.maventest.constraints.SecondsFuture;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by tong on 1/14/16.
 */
public class SecondsFutureValidator implements ConstraintValidator<SecondsFuture, Object> {

    @Override
    public void initialize(SecondsFuture constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }

        return Long.valueOf(value.toString()).compareTo(
                context.unwrap(HibernateConstraintValidatorContext.class).getTimeProvider().getCurrentTime()) == 1;
    }
}
