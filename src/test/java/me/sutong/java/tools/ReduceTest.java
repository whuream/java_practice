package me.sutong.java.tools;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by tong on 3/31/16.
 */
public class ReduceTest {

    @Test
    public void testReduce() throws Exception {
        System.out.println(Reduce.reduce(Arrays.asList(1, 2, 3).iterator(), 10,
                new Reduce.Function<Integer, Integer>() {
                    public Integer apply(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
                }));
    }
}