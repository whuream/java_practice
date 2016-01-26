import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by tong on 1/26/16.
 */
public class Log4jTest {
    private static Logger logger = Logger.getLogger(Log4jTest.class);

    @Test
    public void test(){
        logger.debug("debug");
        logger.info("info");
    }
}
