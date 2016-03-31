package me.sutong.java.logging;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tong on 3/31/16.
 */
public class SLF4JTest {

    private static Logger logger = LoggerFactory.getLogger(SLF4JTest.class);

    @Test
    public void test(){
        logger.debug("slf4j debug");
        logger.info("slf4j info");
    }
}
