package com.ream.www.maventest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by tong on 12/10/15.
 */
public class JsonTest {

    public static class C1{
        private Integer integer = 100;
        private Boolean aBoolean = false;

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        public Boolean getaBoolean() {
            return aBoolean;
        }

        public void setaBoolean(Boolean aBoolean) {
            this.aBoolean = aBoolean;
        }
    }

    public static class C2<T>{
        private T t;
        private Long aLong = 98l;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public Long getaLong() {
            return aLong;
        }

        public void setaLong(Long aLong) {
            this.aLong = aLong;
        }
    }

    @Test
    public void test1(){
        C1 c1 = new C1();
        String string = JSON.toJSONString(c1);

        System.out.println(string);

        C1 c2 = JSON.parseObject(string, C1.class);

        TypeToken typeToken = new TypeToken<C1>(){};

        C1 c3 = JSON.parseObject(string, typeToken.getType());

        C1 c4 = JSON.parseObject(string, new TypeReference<C1>(){});


    }

    @Test
    public void test2(){
        C2<C1> c1C2 = new C2<C1>();
        c1C2.setT(new C1());

        String string = JSON.toJSONString(c1C2);
        System.out.println(string);

        C2<C1> c1C21 = JSON.parseObject(string, new TypeReference<C2<C1>>(){});

        TypeToken typeToken = new TypeToken<C2<C1>>(){};

        C2<C1> c1C22 = JSON.parseObject(string, typeToken.getType());

    }

    @Test
    public void test3(){
        getType(new C1());
        getType2(new C1());
    }

    // not work
    public <T> void getType(T t){
        Type type = new TypeReference<T>(){}.getType();
    }

    public <T> void getType2(T t){
        // not work
        //Type type = new TypeToken<T>(){}.getType();

        //not work
        Type type2 = new TypeToken<T>(getClass()){}.getType();

    }

    @Test
    public void test4(){
        Type type = mapType(new TypeToken<C2<C1>>(){}, C1.class);
    }

    static <K, V> Type mapType(TypeToken<K> k, Class<V> v) {
        return new TypeToken<Map<K, V>>() {}
                .where(new TypeParameter<K>() {}, k)
                .where(new TypeParameter<V>() {}, v).getType();
    }


}
