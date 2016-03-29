package com.ream.www.maventest.util;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by tong on 10/30/15.
 */
public class ValidateHelper {
    public static void validate(Object object){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);

        System.out.println(Joiner.on("\n").join(Iterators.transform(constraintViolations.iterator(),
                new Function<ConstraintViolation<Object>, String>() {
                    public String apply(ConstraintViolation<Object> input) {

                        return Joiner.on("->").join(Lists.newArrayList(input.getRootBeanClass().toString(),
                                input.getPropertyPath(),
                                input.getInvalidValue().toString(),
                                input.getMessage()));
                    }
                })));
    }
}
