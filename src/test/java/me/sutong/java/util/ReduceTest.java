package me.sutong.java.util;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import me.sutong.java.util.function.Reduce;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tong on 1/22/16.
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

    @Test
    public void testCollection(){
        List<ArrayList<Long>> listList = Lists.newArrayList(Lists.newArrayList(1l, 2l), Lists.newArrayList(2l, 3l));
        List<Long> longs = Reduce.reduce(listList.iterator(), new ArrayList<Long>(),
                new Reduce.Function<ArrayList<Long>, ArrayList<Long>>() {
                    public ArrayList<Long> apply(ArrayList<Long> longs, ArrayList<Long> longs2) {
                        longs2.addAll(longs);
                        return longs2;
                    }
                });

        System.out.println(JSON.toJSONString(longs));
    }

    @Test
    public void testMap(){
        System.out.println(Lists.transform(Lists.newArrayList(1l, 2l, 3l),
                new Function<Long, Long>() {
                    @Override
                    public Long apply(Long input) {
                        return input * input;
                    }
                }));

        System.out.println(Lists.newArrayList(Iterators.filter(Lists.newArrayList(1l, 2l, 3l).iterator(),
                new Predicate<Long>() {
                    @Override
                    public boolean apply(Long input) {
                        return input > 2;
                    }
                })));
    }

    @Test
    public void testMapJ8(){
        System.out.println(Stream.of(1l, 2l, 3l).map(t -> t * t).collect(Collectors.toList()));

        System.out.println(Stream.of(1l, 2l, 3l).map(t -> t * t).reduce(new ArrayList<Long>(),
                (longs, aLong) -> {
                    longs.add(aLong);
                    return longs;
                }, (longs, longs2) -> {
                    longs.addAll(longs2);
                    return longs;
                }));

        System.out.println(Stream.of(1l, 2l, 3l).filter(t -> t > 2).collect(Collectors.toList()));

        System.out.println(Stream.of(1l, 2l, 3l).reduce(100l, (a, b) -> a + b));

        System.out.println(0);

        Stream<Long> stream = Lists.newArrayList(1l, 2l, 3l).stream();

        System.out.println(stream.isParallel());

        Long a = stream.reduce(100l, (b, c) -> b + c);
    }
}