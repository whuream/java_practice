package com.ream.www.maventest.advice;


import com.ream.www.maventest.utils.Helper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

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
    private static final String str = "INAdvice";

    @Around("execution(* com.ream.www.maventest.advice.AdviceTest.print(..))")
    private String doAround(ProceedingJoinPoint pjp){

        try {
            Object result = pjp.proceed(pjp.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println(str);
        return str;
    }
}
