import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * Created by tong on 1/26/16.
 */
public class CommonLoggingTest {

    private static Log log = LogFactory.getLog(CommonLoggingTest.class);

    @Test
    public void test(){
        log.info("info");
        log.debug("debug");
    }
}
