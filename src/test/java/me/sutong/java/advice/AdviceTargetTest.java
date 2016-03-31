package me.sutong.java.advice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by tong on 3/31/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class AdviceTargetTest {

    @Resource
    AdviceTarget adviceTarget;

    @Test
    public void testSquare() throws Exception {
        // static method can not be proxied
        // noon bean class can not be proxied
        System.out.println(adviceTarget.square(2l));
    }
}