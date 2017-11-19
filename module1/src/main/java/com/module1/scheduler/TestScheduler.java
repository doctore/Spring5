package com.module1.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TestScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger (TestScheduler.class);

    @Scheduled(initialDelay = 5000, fixedDelay = 2500)
    public void test() {

        LOGGER.info ("prueba2");
    }

}
