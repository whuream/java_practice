package me.sutong.java.tools;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by tong on 3/31/16.
 */
public class ZipTest {

    @Test
    public void testZip() throws Exception {
        System.out.println(Zip.zip(Stream.of(1l, 2l, 3l), Stream.of(4l, 5l, 6l), (aLong, aLong2) -> aLong + aLong2)
                .collect(Collectors.toList()));
    }
}