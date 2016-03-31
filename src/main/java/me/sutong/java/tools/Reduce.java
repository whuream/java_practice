package me.sutong.java.tools;

/**
 * Created by tong on 1/11/16.
 */

import java.util.Iterator;

/**
 * Created by tong on 1/11/16.
 */
public class Reduce {

    public interface Function<T, R> {
        R apply(T t, R r);
    }

    public static <T, R> R reduce(final Iterator<? extends T> iterator, final R begin,
                                  final Function<? super T, R> function) {
        R ret = begin;
        while (iterator.hasNext()) {
            ret = function.apply(iterator.next(), ret);
        }

        return ret;
    }
}

