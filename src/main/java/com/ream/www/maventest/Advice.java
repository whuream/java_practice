package com.ream.www.maventest;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.executable.ExecutableValidator;
import java.util.Set;

/**
 * Created by tong on 10/30/15.
 */

@Component("advice")
@Aspect
public class Advice {

    @Around("execution(* com.ream.www.maventest.ClassA.returnString(..))")
    private String doAround(ProceedingJoinPoint pjp){
        String result = null;
        Object[] objs = pjp.getArgs();
        ExecutableValidator executableValidator = Validation.buildDefaultValidatorFactory().getValidator().forExecutables();

        Set<ConstraintViolation<Object>> constraintViolations = executableValidator.validateParameters(pjp.getThis(),
                ((MethodSignature)pjp.getSignature()).getMethod(), objs);

        if(constraintViolations.size() > 0){
            System.out.println("***********************\n\n\n\n\n\n\n");
        }
        Helper.printV(constraintViolations);

        try {
            result = (String) pjp.proceed(pjp.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("000");
        return "iii";
    }

    @AfterReturning("execution(* com.ream.www.maventest.ClassC.returnString(..))")
    private String doAfter(){
        System.out.println("aaa");
        return "a";
    }
}
