package launch;

import io.sentry.ITransaction;
import io.sentry.Sentry;
import io.sentry.SpanStatus;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

@Log4j2
public class Main {
    public static void main(String[] args) {
        Sentry.init(options -> {
            options.setDsn("https://1f7e7c322a0b40de8e776b9ce4d5f03a@o4504146384388096.ingest.sentry.io/4504146396119041");
            // Set tracesSampleRate to 1.0 to capture 100% of transactions for performance monitoring.
            // We recommend adjusting this value in production.
            options.setTracesSampleRate(1.0);
            // When first trying Sentry it's good to see what the SDK is doing:
            options.setDebug(true);
        });
        try {
            throw new Exception("Test!");
        } catch (Exception e){
            System.out.println("Sending exception");
            Sentry.captureException(e);
        }
        ITransaction transaction = Sentry.startTransaction("processOrderBatch()", "task");
        try {
            System.out.println("test");
        } catch (Exception e) {
            transaction.setThrowable(e);
            transaction.setStatus(SpanStatus.INTERNAL_ERROR);
            throw e;
        } finally {
            transaction.finish();
        }
        System.out.println("Log level: " + log.getLevel());
        System.out.println("Log file    : " + System.getProperty("log4j2.configurationFile"));
        log.error("Error-logging is working!");
        log.info("Launching Application");

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        String port = System.getenv("DevOpsPort");
        port = port !=null ? port:"8080";

        tomcat.setPort(Integer.parseInt(port));
        tomcat.getConnector();
        tomcat.addWebapp("",new File("src/main/webapp").getAbsolutePath());

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {

            throw new RuntimeException(e);
        }

    }
}
