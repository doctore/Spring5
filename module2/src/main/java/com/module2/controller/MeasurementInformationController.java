package com.module2.controller;

import com.module2.Constants;
import com.module2.dto.MeasurementInformationDto;
import com.module2.model.MeasurementInformation;
import com.module2.repository.impl.MeasurementInformationRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class MeasurementInformationController {

    private static final Logger LOGGER = LoggerFactory.getLogger (MeasurementInformationController.class);

    @Autowired
    private MeasurementInformationRepositoryImpl measurementInformationRepository;


    @KafkaListener(topics = Constants.KAFKA_TOPIC, groupId = Constants.KAFKA_GROUPID)
    public void newMeasurementInformationListener (MeasurementInformationDto measurementInformationDto) {

        LOGGER.info ("A message has been received: " + measurementInformationDto);
        measurementInformationRepository.save (measurementInformationDto.aircraft
                                              ,new MeasurementInformation(measurementInformationDto));

        LOGGER.info ("The following parameters have been added in in-memory database: "
                   + measurementInformationRepository.getParameterValues (measurementInformationDto.aircraft));

        /*
        Iterable<MeasurementInformation> measurements = measurementInformationRepository.findAll();
        measurements.forEach ( mi -> LOGGER.info ("USING findAll: " + mi));

        Optional<MeasurementInformation> mi = measurementInformationRepository.findById (measurementInformationDto.aircraft);
        LOGGER.info ("USING findById: " + mi.get());

        measurementInformationRepository.deleteAll();

        LOGGER.info ("USING count: " + measurementInformationRepository.count());
        */
    }

}
