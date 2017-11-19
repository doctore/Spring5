package com.module2.scheduler;

import com.module2.repository.MeasurementInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CheckIgniteInformationScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger (CheckIgniteInformationScheduler.class);

    @Autowired
    private MeasurementInformationRepository measurementInformationRepository;


    @Scheduled (initialDelay = 10000, fixedDelay = 25000)
    public void measurementInformation() {

        LOGGER.info ("Currently, the are " + measurementInformationRepository.count()
                   + " measurement information rows stored in Ignite");
    }

}
