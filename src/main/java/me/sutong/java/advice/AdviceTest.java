package me.sutong.java.advice;

import org.springframework.stereotype.Component;

/**
 * Created by tong on 1/22/16.
 */
@Component("adviceTest")
public class AdviceTest {
    private static final String str = "AdviceTest";

    public String print(){
        System.out.println(str);

        return str;
    }
}
