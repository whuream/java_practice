package com.ream.www.maventest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import com.ream.www.maventest.dto.ClassA;
import com.ream.www.maventest.dto.ClassB;
import com.ream.www.maventest.dto.User;
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
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

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
        User user = new User(null, "tanlan", "123", 10);
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

        ClassB classB = new ClassB();
        ClassA classA = (ClassA) classB;
        ClassB classB1 = (ClassB) classA;

        System.out.println(classA.int3);
        System.out.println(classB1.int3);


        ClassA classA1 = new ClassB();
        ClassB classB2 = (ClassB) classA1;

        System.out.println(classA1.int3);
        System.out.println(((ClassB) classA1).int3);
        System.out.println(classB2.int3);

    }

    @Test
    public void test6(){
        ClassA classA = new ClassA();
        System.out.println(classA.getInt1());
    }

    public void swap(int a){
        a = 0;
    }

    public void swap(Integer a){
        a = 0;
    }

    public void swap(ClassA a){
        a = new ClassA();
        a.int3 = 1099;
    }

    @Test
    public void test7(){
        int a = 100;
        swap(a);
        System.out.println(a);

        Integer b = 100;
        swap(b);
        System.out.println(b);

        ClassA classA = new ClassA();
        swap(classA);
        System.out.println(classA.int3);

        Integer i1 = 100001;

        Integer i2 = 100000;
        i2 += 1;

        int i3 = 100001;

        System.out.println(i1 == i3);
    }

    class I4{
        public int i1 = 888;
        public Integer i2 = 888;
    }

    class I3{
        public int i1 = 999;
        public Integer i2 = 999;

        public I4 i4 = new I4();
    }

    public void change(int a){
        a = 0;
    }

    public void change(Integer a){
        a = 0;
    }

    public I4 change(I3 i3){
        i3.i1 = 0;
        i3.i2 = 0;

        return i3.i4;
    }

    public void change2(I3 i3){
        i3 = new I3();
        i3.i1 = 0;
        i3.i2 = 0;
    }


    @Test
    // function in test
    public void test8(){
        // int use value
        int i1 = 999;
        change(i1);
        System.out.println(i1);

        // Integer use value (or no values pointer?)
        Integer i2 = 999;
        change(i2);
        System.out.println(i2);

        // object use pointer
        I3 i3 = new I3();
        change(i3);
        System.out.println(i3.i1 + i3.i2);

        I3 i4 = new I3();
        change2(i4);
        System.out.println(i4.i1 + i4.i2);
    }

    @Test
    // function out test
    public void test9(){
        // int and Integer use value obviously

        // object use pointer
        I3 i3 = new I3();
        i3.i4.i1 = 999;
        i3.i4.i2 = 999;

        I4 i4 = change(i3);
        System.out.println(i4.i1 + i4.i2);

        i3.i4.i1 = 0;
        i3.i4.i2 = 0;
        System.out.println(i4.i1 + i4.i2);

        i3.i4 = null;

        System.out.println(i4.i1 + i4.i2);

        Integer i1 = new Integer(100);
        Integer i2 = i1;
        i2 = 0;
        System.out.println(i1);
    }

    @Test
    // = test
    public void test10(){
        // Integer use value
        Integer i1 = new Integer(100);
        Integer i2 = i1;
        i1 = 0;
        System.out.println(i2);

        // Object use pointer
        I4 i4 = new I4();
        I4 i41 = i4;
        i4.i2 = 0;
        System.out.println(i41.i2);
    }

    public class A{
        public int a;
        public int getA(){
            return a;
        }
    }
    public class B extends A{
        public int a;
        public int getA()
        {
            return a;
        }
    }

    @Test
    public void test11(){
        B b = new B();
        b.a = 100;

        A a = (A)b;

        System.out.println(b.a + b.getA());
        System.out.println(a.a + a.getA());

    }

    public class Ab{

    }

    public class Ab1 extends Ab{

    }

    public void testA(Object a){
        Ab1 a1 = (Ab1)a;
        System.out.println('s');
    }

    @Test
    public void test12(){
        testA(new Ab1());
    }

    @Test
    public void test13(){
        System.out.println(-1 / 10);
    }

    @Test
    public void test14(){

    }

    public static class A1<T>{
        public T t;
        public long test;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public long getTest() {
            return test;
        }

        public void setTest(long test) {
            this.test = test;
        }
    }

    public static class A2{
        private int t2;

        public int getT2() {
            return t2;
        }

        public void setT2(int t2) {
            this.t2 = t2;
        }
    }

    public static class A21{
        protected A21(String a){
            System.out.println("a21");
        }
    }

    public static class A22 extends A21{
        {
            System.out.println("def");
        }
        public A22(int a){
            super("a");
            System.out.println("a22");
        }
    }

    public static <T extends A1> void test01(T a){
        System.out.println(((ParameterizedType) (Type)a.getClass()).getActualTypeArguments()[0]);
        A2 a2 = (A2) a.getT();
    }

    public static <T> void test02(){

    }

    public static <T> T getMiddle(T...a){
        return a[a.length/2];
    }

    public static class test001<T>{
        public test001(){
            Class cl = getClass();
            Type ty = cl.getGenericSuperclass();
        }
    }

    @Test
    public void test15(){
        test001<A1<A2>> a1test001 = new test001<A1<A2>>();



        A1<A2> a2A1 = new A1<A2>();
        a2A1.setT(new A2());
        //test01(a2A1);


        System.out.println(a2A1.getClass().toString());
        //Class<A1<A2>> c = a2A1.getClass();

        TypeReference t = new TypeReference<A1<A2>>(){};

        A1<A2> a = new A1<A2>();
        a.t = new A2();
        String s = JSON.toJSONString(a);
        System.out.println(s);

        A1<A2> a11 = JSON.parseObject(s, new TypeReference<A1<A2>>(){});

        A2 a21 = (A2)a11.getT();


        A2 a2 = new A2();
        a2.t2 = 100;
        String s2 = JSON.toJSONString(a2);
        System.out.println(s2);

        A2 a22 = JSON.parseObject(s2, A2.class);

        A21 a221 = new A21("1"){};

        A21 a211 = new A22(1);



    }

    @Test
    public void test0009(){
        A1<A2> a2A1 = new A1<A2>();
        Class cl = a2A1.getClass();
        //ParameterizedType parameterizedType = (ParameterizedType) (Type)cl;

    }

    public static class B1<T>{
        public Type getType(){
            TypeToken typeToken = new TypeToken(getClass()) {
            };
            System.out.println(typeToken);
            return typeToken.getType();
        }

    }

    public static class B2 extends B1<String>{

    }

    public static <T> Type getType(){
        TypeToken typeToken = new TypeToken<List<T>>() {
        }.where(new TypeParameter<T>() {
        }, (Class<T>)Long.class);
        return typeToken.getType();
    }

    static <K, V> TypeToken<Map<K, V>> mapOf() {
        return new TypeToken<Map<K, V>>() {}
                .where(new TypeParameter<K>() {
                }, (Class<K>)String.class)
                .where(new TypeParameter<V>() {
                }, (Class<V>)Long.class);
    }

    public static class TA{
        private int a;

        public Integer bccc = 100;

        public Boolean bbb = false;

        public Boolean bca = true;

        public int getB(){
            return 120;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

    @Test
    public void testB1(){

        TypeToken t = mapOf();
        Type ty = t.getType();

        ty = getType();

    }

    public static class BaseClass<T> {
        private final TypeToken typeToken = new TypeToken<T>(getClass()) {};
        private final Type type = typeToken.getType();

        public Type getType(){
            return type;
        }
    }

    @Test
    public void testBC(){
        BaseClass<String> stringBaseClass = new BaseClass<String>();
        Type t = stringBaseClass.getType();

        TA ta = new TA();
        String s = JSON.toJSONString(ta);

        System.out.println(s);


        TA ta1 = JSON.parseObject(s, TA.class);

    }

}

