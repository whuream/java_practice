
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tong on 2/18/16.
 */
public class SLF4JTest {

    private final Logger slf4jLogger = LoggerFactory.getLogger(SLF4JTest.class);

    @Test
    public void test(){
        slf4jLogger.debug("debug");
        slf4jLogger.info("info");
    }
}
