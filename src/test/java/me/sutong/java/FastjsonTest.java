package me.sutong.java;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by tong on 3/31/16.
 */
public class FastjsonTest {

    public static class Car {

    }


    @Test
    public void test() {
        String string = JSON.toJSONString(new Car());

//        Car car = JSON.parseObject(string, Car.class);

        Car car = JSON.parseObject(string, new TypeReference<Car>(){});

//        Car car = JSON.parseObject(string, new TypeToken<Car>(){}.getType());

        System.out.println(JSON.toJSONString(car));
    }

    public static <K, V> Type mapType(TypeToken<K> k, Class<V> v) {
        return new TypeToken<Map<K, V>>() {}
                .where(new TypeParameter<K>() {}, k)
                .where(new TypeParameter<V>() {}, v).getType();
    }

    @Test
    public void testGeneric(){
        String string = JSON.toJSONString(Arrays.asList(new Car(), new Car()));

//        List<Car> cars = JSON.parseObject(string, new TypeReference<List<Car>>(){});

        List<Car> cars = JSON.parseObject(string, new TypeToken<List<Car>>(){}.getType());

        System.out.println(JSON.toJSONString(cars));
    }

    @Test
    public void typeTokenTest(){
        Type type = mapType(new TypeToken<List<Car>>() {}, Car.class);

        System.out.println(type);
    }
}
