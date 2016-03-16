package com.ream.www.maventest.constraints;

import com.ream.www.maventest.constraintValidator.SecondsFutureValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created by tong on 1/14/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Constraint(validatedBy = SecondsFutureValidator.class)
@Documented
public @interface SecondsFuture {
    String message() default "{javax.validation.constraints.Future.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
