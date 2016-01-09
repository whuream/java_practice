package com.ream.www.maventest;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by tong on 1/9/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = CheckFValidator.class)
@Documented
public @interface CheckF {
    String message() default "123";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};

    long time();
}
