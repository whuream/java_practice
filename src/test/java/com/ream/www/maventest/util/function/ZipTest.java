package com.ream.www.maventest.util.function;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by tong on 3/29/16.
 */
public class ZipTest extends TestCase {

    @Test
    public void test(){
        List<Long> list = Lists.newArrayList(Zip.zip(Lists.newArrayList(1l, 2l, 3l).iterator(),
                Lists.newArrayList(4l, 5l, 6l).iterator(), new BiFunction<Long, Long, Long>() {
                    @Override
                    public Long apply(Long aLong, Long aLong2) {
                        return aLong * aLong2;
                    }
                }));

        System.out.println(JSON.toJSONString(list));
    }

}