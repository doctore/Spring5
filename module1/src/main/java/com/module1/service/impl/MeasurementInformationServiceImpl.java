package com.module1.service.impl;

import com.module1.Constants;
import com.module1.dto.MeasurementInformationDto;
import com.module1.model.MeasurementInformation;
import com.module1.repository.MeasurementInformationRepository;
import com.module1.service.MeasurementInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MeasurementInformationServiceImpl implements MeasurementInformationService {

    private static final Logger LOGGER = LoggerFactory.getLogger (MeasurementInformationServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private MeasurementInformationRepository measurementInformationRepository;


    /** {@inheritDoc} */
    @Override
    public boolean addMeasurementInformation (MeasurementInformationDto measurementInformationDto) {

        try {
            MeasurementInformation measurementInformation = new MeasurementInformation (measurementInformationDto);
            measurementInformationRepository.save (measurementInformation);
            LOGGER.info ("The measurement information: " + measurementInformation + " has been saved in database");

            kafkaTemplate.send (Constants.KAFKA_TOPIC, measurementInformationDto);
            return true;

        } catch (Exception e) {

            LOGGER.info ("There was an error trying to save the measurement information: "
                       + measurementInformationDto, e);
            return false;
        }
    }

}
