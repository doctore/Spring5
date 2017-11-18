package com.module1.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@EnableScheduling
public class TestScheduler {

    private static final Logger LOGGER = Logger.getLogger (TestScheduler.class.getName());

    @Scheduled(initialDelay = 5000, fixedDelay = 2500)
    public void test() {

        LOGGER.info("prueba2");
    }

}
