package com.ream.www.maventest;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by tong on 12/15/15.
 */
public class pairTest {

    public static String buildShippingType(String date){
        Map<String, String> json = new HashMap<String, String>();
        json.put("SHIPPING_TYPE", "SHIPPING_BEFORE_TIME");
        json.put("SHIPPING_DESC", date);

        return JSON.toJSONString(json);
    }

    public static String parseShippingType(String json){
        return JSON.parseObject(json).getObject("SHIPPING_DESC", String.class);
    }

    @Test
    public void test(){
        Pair<Long, Long> pair = Pair.of(12l, 34l);
        System.out.println(pair.getRight());

        LinkedHashSet<Long> set = new LinkedHashSet<Long>(){{add(12l);}};

        System.out.println(JSON.toJSONString(set));

        Void a;

        Double d = 0/0d;

        System.out.println(d);

        System.out.println(Double.SIZE);
        System.out.println(Double.MAX_EXPONENT);
        System.out.println(Double.MIN_EXPONENT);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.POSITIVE_INFINITY);

        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MIN_NORMAL);

        System.out.println(Double.MAX_VALUE + 1);
        System.out.println(Double.MAX_VALUE * 2);

        System.out.println(1 - Double.MIN_VALUE);
        System.out.println(Double.MIN_VALUE / 2);

        // double.max_value + 1 round to double.max_value
        System.out.println(Double.valueOf(Double.MAX_VALUE + 1).equals(Double.MAX_VALUE));


        Map<Long, Set<Long>> test = new LinkedHashMap<Long, Set<Long>>();

        Map<Long, Map<Long, Long>> mtest = Maps.transformValues(test, new Function<Set<Long>, Map<Long, Long>>() {
            public Map<Long, Long> apply(Set<Long> input) {
                return new LinkedHashMap<Long, Long>();
            }
        });

        Map<Long, Long> maps = new LinkedHashMap();
        maps.remove(123l);

        Date date = new Date();

        System.out.println(JSON.toJSONString(date));

        System.out.println(Double.valueOf(123.45).intValue());

        System.out.println(buildShippingType("123"));
        System.out.println(parseShippingType(buildShippingType("999")));

        BigDecimal bd = BigDecimal.valueOf(123.11);
        bd.setScale(2);

        System.out.println(bd.toPlainString());

    }

    @Test
    public void arrayTest(){
        String[] longs = {"1", "2", "3"};
        System.out.println(Joiner.on(",").join(longs));


    }
}
