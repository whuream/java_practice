package me.sutong.java.advice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tong on 1/22/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:maven_test-servlet.xml"})
public class AdviceTestTest {
    @Resource
    private AdviceTest adviceTest;

    @Resource
    private NoAdviceTest noAdviceTest;

    @Test
    public void testPrint() throws Exception {
        System.out.println(adviceTest.print());

        AdviceTest adviceTest1 = new AdviceTest();

        // this obj is not the bean obj
        NoAdviceTest noAdviceTest1 = new NoAdviceTest();

        // advice not work in this new created non bean object
        System.out.println(adviceTest1.print());

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
}