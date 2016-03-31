package com.ream.www.maventest.util.function;

import java.util.Iterator;

/**
 * Created by tong on 3/29/16.
 */
public class Zip {
    public static <T, U, R> Iterator<R> zip(final Iterator<? extends T> iteratorT, final Iterator<? extends U> iteratorU,
                                  final BiFunction<? super T, ? super U, ? extends R> function){

        return new Iterator<R>() {
            @Override
            public boolean hasNext() {
                return iteratorT.hasNext() && iteratorU.hasNext();
            }

            @Override
            public R next() {
                return function.apply(iteratorT.next(), iteratorU.next());
            }
        };
    }
}
