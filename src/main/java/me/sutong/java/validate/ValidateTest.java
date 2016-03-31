package me.sutong.java.validate;

import javax.validation.constraints.Min;

/**
 * Created by tong on 1/22/16.
 */
public class ValidateTest {
    @Min(value = 1000)
    private Long a = 100l;

    public Long getA() {
        return a;
    }

    public void setA(Long a) {
        this.a = a;
    }
}
