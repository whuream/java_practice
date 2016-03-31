package me.sutong.java.logging;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tong on 3/31/16.
 */
public class LogbackTest {

    private static Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void test(){
        logger.debug("slf4j debug");

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(loggerContext);
    }
}
