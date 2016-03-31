package me.sutong.java.advice;

import org.springframework.test.context.ContextConfiguration;

/**
 * Created by tong on 3/31/16.
 */
public class AdviceTarget {

    public static Long square(Long input){
        return input * input;
    }
}
