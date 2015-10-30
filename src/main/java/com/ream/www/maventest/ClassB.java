package com.ream.www.maventest;

import javax.validation.constraints.Size;

/**
 * Created by tong on 10/16/15.
 */
public class ClassB extends ClassA {
    @Size(min = 1000)
    public Long aLong;

    public void method2(){
        System.out.println("ClassB-method2");
    }



}
