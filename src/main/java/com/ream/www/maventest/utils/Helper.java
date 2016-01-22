package com.ream.www.maventest.utils;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by tong on 10/30/15.
 */
public class Helper {
    public static void printV(Set<ConstraintViolation<Object>> constraintViolations){
        System.out.println(Joiner.on(";").join(Iterators.transform(constraintViolations.iterator(),
                new Function<ConstraintViolation<Object>, String>() {
                    public String apply(ConstraintViolation<Object> input) {
                        return Joiner.on("***").join(Lists.newArrayList(input.getRootBeanClass().toString(),
                                input.getPropertyPath(),
                                input.getInvalidValue().toString(),
                                input.getMessage()));
                    }
                })));
    }
}
