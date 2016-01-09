package com.ream.www.maventest;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 1/8/16.
 */
public class typeTest {

    public class A1<T>{

    }

    public class A2 extends A1<String>{

    }

    public class A4 extends A1<List<String>>{

    }

    public class A3<P> extends A1<P>{

    }


    public class A5<P> extends A1<List<P>>{

    }

    public class A6<T extends String>{

    }

    public class B1 extends ArrayList {
        {add("123");}
    }

    public class B2 extends ArrayList<String>{
        {add("123");}
    }

    public class B3<E> extends ArrayList<E>{
        E e;
    }

    public void m1(ArrayList arrayList){
        System.out.println(JSON.toJSONString(arrayList));
    }

    public void m2(ArrayList<Object> arrayList){
        System.out.println(JSON.toJSONString(arrayList));
    }

    public class C1{
    }

    public class C2 extends C1{

    }

    public class C3 extends C2{

    }

    public void m3(ArrayList<? extends C2> arrayList){
        System.out.println(arrayList);
    }

    public void m4(ArrayList<? super C2> arrayList){

    }

    public void m5(ArrayList<?> arrayList){

    }

    public void m6(ArrayList<? extends Object> arrayList){

    }

    public void m7(ArrayList<? super Object> arrayList){

    }

    @Test
    public void test(){
        Type type;
        TypeVariable[] tValue;
        tValue = List.class.getTypeParameters();
        System.out.println(tValue[0].getName());
        System.out.println(JSON.toJSONString(tValue));

        tValue = A6.class.getTypeParameters();
        System.out.println(tValue[0].getName());
        System.out.println(JSON.toJSONString(tValue));

        type = A2.class.getGenericSuperclass();

        System.out.println(JSON.toJSONString(type));

        type = A4.class.getGenericSuperclass();

        System.out.println(JSON.toJSONString(type));

        type = A3.class.getGenericSuperclass();

        System.out.println(JSON.toJSONString(type));

        type = A5.class.getGenericSuperclass();

        System.out.println(JSON.toJSONString(type));
    }

    @Test
    public void test2(){
        m1(new B1());

        m1(new B2());

        m1(new B3<String>());

        m2(new B1());

        m2(new ArrayList<Object>());

//        m2(new ArrayList<String>());

        m2(new B3());

        m2(new B3<Object>());

        m3(new ArrayList<C2>());

        m3(new ArrayList<C3>());

//        m3(new ArrayList<C1>());

        m4(new ArrayList<C2>());

        m4(new ArrayList<C1>());

//        m4(new ArrayList<C3>());

        m5(new ArrayList<Object>());

        m5(new ArrayList<String>());

        m6(new ArrayList<Object>());

        m6(new ArrayList<String>());

        m7(new ArrayList<Object>());

//        m7(new ArrayList<String>());

        m7(new ArrayList());

        Method[] methods = this.getClass().getDeclaredMethods();

        for(Method method: methods){
            if(method.getName().equals("m7")){
                Type[] types = method.getGenericParameterTypes();

                System.out.println(JSON.toJSONString(types));

                System.out.println(JSON.toJSONString(method));
            }
        }
    }
}
