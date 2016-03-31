package me.sutong.java.tools;

import com.google.common.collect.Lists;
import me.sutong.java.function.BiFunction;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by tong on 3/31/16.
 */
public class ZipJ7Test {

    @Test
    public void testZip() throws Exception {
        System.out.println(Lists.newArrayList(ZipJ7.zip(Arrays.asList(1l, 2l, 3l).iterator(),
                Lists.newArrayList(4l, 5l, 6l).iterator(),
                new BiFunction<Long, Long, Long>() {
                    @Override
                    public Long apply(Long aLong, Long aLong2) {
                        return aLong * aLong2;
                    }
                })));
    }
}