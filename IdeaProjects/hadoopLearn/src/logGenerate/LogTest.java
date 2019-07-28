package logGenerate;

import org.apache.log4j.Logger;

public class LogTest {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Logger logger = Logger.getLogger("logRollingFile");
            logger.info("hello, world! ---------------"+System.currentTimeMillis());
            Thread.sleep(50);
        }
    }

}
