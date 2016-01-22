package com.ream.www.maventest.utils;

import com.google.common.collect.Lists;
import org.junit.Test;

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
}