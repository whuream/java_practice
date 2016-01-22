package com.ream.www.maventest.advice;

import org.springframework.stereotype.Component;

/**
 * Created by tong on 1/22/16.
 */
@Component("NoAdviceTest")
public class NoAdviceTest {
    private static final String str = "noAdviceTest";

    public String print(){
        System.out.println(str);

        return str;
    }
}
