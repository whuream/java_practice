package me.sutong.java.function;

/**
 * Created by tong on 3/29/16.
 */
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}
