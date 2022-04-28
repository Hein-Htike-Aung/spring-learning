package com.demo.no.aop.logger;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.logging.Logger;

@Component
public class PerformanceLogger {

    private Logger logger = Logger.getLogger("performance.logger");

    public PerformaceLoggerInfo start(String name){
        return new PerformaceLoggerInfo(name, System.currentTimeMillis());
    }

    public void stop(PerformaceLoggerInfo performaceLoggerInfo) {

        long startTime = performaceLoggerInfo.getStartTime();

        long finishTime = System.currentTimeMillis();

        logger.info(String.format("Duration of %s execution %s",
                performaceLoggerInfo.getName(), Duration.ofMillis(finishTime - startTime)));
    }

    // Helper class
    public static class PerformaceLoggerInfo {

        private final String name;

        private final long startTime;

        public PerformaceLoggerInfo(String name, long startTime) {
            this.name = name;
            this.startTime = startTime;
        }

        public String getName() {
            return name;
        }

        public long getStartTime() {
            return startTime;
        }
    }
}
