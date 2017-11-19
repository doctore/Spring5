package com.module1.scheduler;

import com.module1.repository.MeasurementInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CheckCassandraInformationScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger (CheckCassandraInformationScheduler.class);

    @Autowired
    private MeasurementInformationRepository measurementInformationRepository;


    @Scheduled (initialDelay = 10000, fixedDelay = 25000)
    public void measurementInformation() {

        LOGGER.info ("Currently, the are " + measurementInformationRepository.count()
                   + " measurement information rows stored in Cassandra");
    }

}
