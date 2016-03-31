package me.sutong.java.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * Created by tong on 3/31/16.
 */
public class LoggingTest {

    private static Log log = LogFactory.getLog(LoggingTest.class);

    @Test
    public void test(){
        log.debug("logging debug");
        log.info("logging info");
    }
}
