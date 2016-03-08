package com.ream.www.maventest.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 1/22/16.
 */
public class CollectionUtilTest {

    @Test
    public void testReduce() throws Exception {
        System.out.println(CollectionUtil.reduce(Lists.newArrayList(1, 2, 3).iterator(), 10,
                new CollectionUtil.Function<Integer, Integer>() {
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }));
    }

    @Test
    public void testCollection(){
        List<ArrayList<Long>> listList = Lists.newArrayList(Lists.newArrayList(1l, 2l), Lists.newArrayList(2l, 3l));
        List<Long> longs = CollectionUtil.reduce(listList.iterator(), new ArrayList<Long>(),
                new CollectionUtil.Function<ArrayList<Long>, ArrayList<Long>>() {
            public ArrayList<Long> apply(ArrayList<Long> longs, ArrayList<Long> longs2) {
                longs2.addAll(longs);
                return longs2;
            }
        });

        System.out.println(JSON.toJSONString(longs));
    }
}