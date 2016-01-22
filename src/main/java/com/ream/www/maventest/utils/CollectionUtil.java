package com.ream.www.maventest.utils;

/**
 * Created by tong on 1/11/16.
 */

import com.google.common.collect.Lists;

import java.util.Iterator;

/**
 * Created by tong on 1/11/16.
 */
public class CollectionUtil {

    public interface Function<F, T>{
        T apply(F f, T t);
    }

    public static <F, T> T reduce(final Iterator<F> iterator, final T begin, final Function<? super F, T> function){
        T ret = begin;
        while (iterator.hasNext()){
            ret = function.apply(iterator.next(), ret);
        }

        return ret;
    }

    public static void main(String[] a){
        System.out.println(reduce(Lists.newArrayList(1, 2, 3).iterator(), 10, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }));


    }

}

