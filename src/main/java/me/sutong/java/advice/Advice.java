package me.sutong.java.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by tong on 10/30/15.
 */
@Component("advice")
@Aspect
public class Advice {
    private static final String str = "INAdvice";

    @Around("execution(* me.sutong.java.advice.AdviceTest.print(..))")
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
