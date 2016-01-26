import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by tong on 1/26/16.
 */
public class LoggingTest {

    private static Logger logger = Logger.getLogger(LoggingTest.class.getName());

    @Test
    public void test(){
        logger.finest("finest");
        logger.info("info");

    }
}
