package me.sutong.java.util.function;

import com.google.common.collect.Lists;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tong on 3/29/16.
 */
public class ZipTest extends TestCase {

    @Test
    public void test() {
        System.out.println(Lists.newArrayList(Zip.zip(Arrays.asList(1l, 2l, 3l).iterator(),
                Lists.newArrayList(4l, 5l, 6l).iterator(),
                new BiFunction<Long, Long, Long>() {
                    @Override
                    public Long apply(Long aLong, Long aLong2) {
                        return aLong * aLong2;
                    }
                })));

    }

    @Test
    public void test555() {
        List<Long> longs = new ArrayList<>();
        Arrays.asList(1l, 2l, 3l).forEach(t -> longs.add(t * t));

        System.out.println(longs);

        System.out.println(ZipJ8.zip(Stream.of(1l, 2l, 3l), Stream.of(4l, 5l, 6l), (aLong, aLong2) -> aLong + aLong2)
                .collect(Collectors.toList()));
    }



}