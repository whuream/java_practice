package com.ream.www.maventest;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

/**
 * Created by tong on 10/29/15.
 */
@Component(value = "testClassCbean")
public class ClassC {
    @Min(value = 100000)
    private long a;

    public String returnString(){
        return "123";
    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }
}
