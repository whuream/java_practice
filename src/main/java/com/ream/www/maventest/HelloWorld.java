package com.ream.www.maventest;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelloWorld
{
    static Logger log = Logger.getLogger(HelloWorld.class);

    public static void main(String[] args){

    }

    public static void main1(String[] args)
    {

        ObjectMapper om = new ObjectMapper();
        om.disable(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS);

        ClassB classB = new ClassB();
        classB.method2();

        ClassA classA = (ClassA) classB;
        classA.method1();

        System.out.println(classB.aLong);

        ClassA classA1 = new ClassA();

        ClassA.InnerClass innerClass = new ClassA.InnerClass();

        classA1.setInnerClass(new ClassA.InnerClass());

        Long a = 1l;

        System.out.println(a.equals(1l));

        Boolean b = true;
        Boolean c = Boolean.TRUE;

        System.out.println(new Float(Math.ceil(2.0/3)).intValue());

        System.out.println(new DecimalFormat("#.00").format(new BigDecimal(12.00)));

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ClassA classA2 = (ClassA) ctx.getBean("classAbean");

        //System.out.println(new Gson().toJson(classA2));

        System.out.println(ReflectionToStringBuilder.toString(classA2));
        System.out.println(ReflectionToStringBuilder.reflectionToString(classA2));

        System.out.println(classA2.returnString(120));

        System.out.println(classA2.getClassCBean());
        classA2.getClassCBean().returnString();

        List<String> l = Lists.newArrayList(Iterators.transform(Arrays.asList(classA2.getClass().getMethods()).iterator(), new Function<Method, String>() {
            public String apply(Method input) {
                return input.toString();
            }
        }));
        Collections.sort(l);

        System.out.println(Joiner.on(";\n").join(l));

        System.out.println(l.size());

        System.out.println("\n\n\n***\n\n\n");


        List<String> l1 = Lists.newArrayList(Iterators.transform(Arrays.asList(classA2.getClass().getDeclaredMethods()).iterator(), new Function<Method, String>() {
            public String apply(Method input) {
                return input.toString();
            }
        }));
        Collections.sort(l1);

        System.out.println(Joiner.on(";\n").join(l1));

        System.out.println(l1.size());

        classA2.returnString((Integer)(Object)Integer.valueOf(10));
        //System.out.println(new Genson().serialize(classA2));
        //System.out.println(JSON.toJSONString(classA2));


    }
}