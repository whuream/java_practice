package me.sutong.java.logging;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by tong on 3/31/16.
 */
public class JavaLoggingTest {

    private static Logger logger = Logger.getLogger(JavaLoggingTest.class.getName());

    @Test
    public void test(){
        // use
        // -Djava.util.logging.config.file=/Users/tong/logging.properties
        // to set logging level
        logger.finest("java logging finest");
        logger.info("java logging info");
    }
}
