package com.ream.www.maventest;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by tong on 9/30/15.
 */
public class HelloWorldTest {
    @Test
    public void test2(){
        try{
            int a = 1/0;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Object getO(){
        return new ClassA();
    }

    public void callGetText(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println(o.getClass().getDeclaredMethod("getText").invoke(o));
    }

    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Long> longs = Arrays.asList(1l, 2l, 3l);

        List<String> strings = Lists.newArrayList(Iterators.filter(Iterators.transform(longs.iterator(), new Function<Long, String>() {
            public String apply(Long aLong) {
                return aLong.toString();
            }
        }), new Predicate<String>() {
            public boolean apply(String input) {
                return input.equals("1");
            }
        }));

        System.out.println(strings.toString());
        getO();
        ClassA classA = (ClassA) getO();
        System.out.println(classA.getInt1());

        System.out.println(classA.getClass().getDeclaredMethod("getText").invoke(classA));
        Object a = getO();

        System.out.println(ReflectionToStringBuilder.toString(a));

        System.out.println(a.getClass().getDeclaredMethod("getText").invoke(a));

        ClassA classA1 = new ClassA();
        callGetText(classA1);
    }

    @Test
    public void test4(){
        ClassA classA = new ClassA();
        classA.setInt1(-1);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        User user = new User(1, "tanlan", "123", 10);
        Set<ConstraintViolation<User>> constraintViolations = validator
                .validate(user);

        System.out.println(ReflectionToStringBuilder.toString(constraintViolations));

        for (ConstraintViolation<User> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }

        Set<ConstraintViolation<ClassA>> constraintViolations1 = validator
                .validate(classA);

        System.out.println(ReflectionToStringBuilder.toString(constraintViolations1));

        System.out.println(Joiner.on("aaa\n").join(Lists.newArrayList(Iterators.transform(constraintViolations1.iterator(), new Function<ConstraintViolation<ClassA>, String>() {
            public String apply(ConstraintViolation<ClassA> input) {
                return input.getMessage();
            }
        }))));

        for (ConstraintViolation<ClassA> constraintViolation1 : constraintViolations1) {
            System.out.println(constraintViolation1);
        }

        Pair<Long, String> a = new ImmutablePair<Long, String>(1l, "a");
        MutablePair<Long, String> b = new MutablePair<Long, String>(2l, "b");
        b.setLeft(2l);
        b.setRight("12");
        System.out.println(ReflectionToStringBuilder.toString(b));
    }

    public String valid(@NotNull String a){
        return "aaa";
    }

    @Test
    public void test5(){
        List<Long> longs = new ArrayList<Long>(Arrays.asList(1l,2l,3l));
        System.out.println(Joiner.on("and").join(longs));

        valid(null);
    }
}

