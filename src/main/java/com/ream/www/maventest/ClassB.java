package com.ream.www.maventest;

import javax.validation.constraints.Size;

/**
 * Created by tong on 10/16/15.
 */
public class ClassB extends ClassA {
    @Size(min = 1000)
    public Long aLong;

    private int int1 = 999;

    public int int3 = 9999;

    @Override
    public int getInt1() {
        return int1;
    }

    @Override
    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public void method2(){
        System.out.println("ClassB-method2");
    }



}
