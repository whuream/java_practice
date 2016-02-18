import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tong on 2/18/16.
 */
public class LogbackTest {
    private final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    private final LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();

    @Test
    public void test(){
        logger.debug("debug");
        logger.info("info");

        StatusPrinter.print(lc);

    }
}
