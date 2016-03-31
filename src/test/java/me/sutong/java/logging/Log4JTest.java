package me.sutong.java.logging;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by tong on 3/31/16.
 */
public class Log4JTest {

    private static Logger logger = Logger.getLogger(Log4JTest.class);

    @Test
    public void test(){
        logger.debug("log4j debug");

        logger.info("log4j info");
    }
}
