package me.sutong.java.advice;

import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by tong on 3/31/16.
 */
@Component("adviceTarget")
public class AdviceTarget {

    public Long square(Long input){
        return input * input;
    }
}
