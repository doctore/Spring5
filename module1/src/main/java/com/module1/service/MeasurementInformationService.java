package com.module1.service;

import com.module1.Constants;
import com.module1.dto.MeasurementInformationDto;

public interface MeasurementInformationService {

    /**
     *    Saves the given {@link MeasurementInformationDto} in database and sends it to the Kafka consumers
     * that are listening in {@link Constants.APPLICATION_PATH#KAFKA_TOPIC}
     *
     * @param measurementInformation
     *    {@link MeasurementInformationDto} to save
     *
     * @return true if the required operations was made without problems, false otherwise
     */
    boolean addNewMeasurementData (MeasurementInformationDto measurementInformation);

}
