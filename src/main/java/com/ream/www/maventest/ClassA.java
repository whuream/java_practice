package com.ream.www.maventest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by tong on 10/16/15.
 */
@Component(value = "classAbean")
public class ClassA {
    public static class InnerClass{
        private long classId;

        public long getClassId() {
            return classId;
        }

        public void setClassId(long classId) {
            this.classId = classId;
        }
    }

    @Min(value = 18)
    private int int1 = 999;
    private int int2;

    public int int3;

    public ClassA(){
        int2 = 100;
    }

    public ClassA(int a){

    }

    @NotNull
    @Size(min = 1)
    private String as = "";

    @NotNull(message = "ab")
    private String ab;

    @Valid
    private ClassC classC = new ClassC();

    @Autowired
    private ClassC classCBean;

    public String returnString(@Min(value = 1000) int a){
        return Integer.toString(a);
    }

    public String getText(){
        return "abcde classA";
    }

    private InnerClass innerClass;

    public InnerClass getInnerClass() {
        return innerClass;
    }

    public void setInnerClass(InnerClass innerClass) {
        this.innerClass = innerClass;
    }

    public void method1(){
        System.out.println("ClassA-method1");
    }


    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public String getAb() {
        return ab;
    }

    public void setAb(String ab) {
        this.ab = ab;
    }

    public ClassC getClassC() {
        return classC;
    }

    public void setClassC(ClassC classC) {
        this.classC = classC;
    }

    public ClassC getClassCBean() {
        return classCBean;
    }

    public void setClassCBean(ClassC classCBean) {
        this.classCBean = classCBean;
    }
}
