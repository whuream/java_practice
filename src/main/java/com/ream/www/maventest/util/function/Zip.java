package com.ream.www.maventest.util.function;

import java.util.Iterator;

/**
 * Created by tong on 3/29/16.
 */
public class Zip {
    public static <T, U, R> Iterator<R> zip(final Iterator<? extends T> iterator1, final Iterator<? extends U> iterator2,
                                  final BiFunction<? super T, ? super U, ? extends R> function){

        return new Iterator<R>() {
            @Override
            public boolean hasNext() {
                return iterator1.hasNext() && iterator2.hasNext();
            }

            @Override
            public R next() {
                return function.apply(iterator1.next(), iterator2.next());
            }
        };
    }
}
