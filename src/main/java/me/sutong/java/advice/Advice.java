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
    private static final String str = "in advice";

    @Around("execution(* me.sutong.java.advice.AdviceTarget.square(..))")
    public Object doAround(ProceedingJoinPoint pjp) {
        Object result = 1l;

        try {
            result = pjp.proceed(pjp.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        System.out.println(str);
        return (Long)result * (Long)result;
    }
}
