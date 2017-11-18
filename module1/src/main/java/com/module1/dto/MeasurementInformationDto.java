package com.module1.dto;

import java.io.Serializable;

/**
 * Used in two different ways:
 *
 * 1. To transform the Json sent by the REST endpoint into an know object
 * 2. Send as "message" through a Kafka producer
 */
public class MeasurementInformationDto implements Serializable {

    private static final long serialVersionUID = -1413873877034596860L;

    public String aircraft;
    public String engine;
    public String parameter1Value;
    public String parameter2Value;
    public String parameter3Value;
    public String parameter4Value;
    public String parameter5Value;

}
