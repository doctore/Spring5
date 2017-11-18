package com.module2.dto;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Used to receive, using a Kafka consumer, the information sent by a Kafka producer (module1)
 */
public class MeasurementInformationDto implements Serializable {

    private static final long serialVersionUID = 7546816066185077771L;

    public String aircraft;
    public String engine;
    public String parameter1Value;
    public String parameter2Value;
    public String parameter3Value;
    public String parameter4Value;
    public String parameter5Value;


    @Override
    public String toString() {
        return "MeasurementInformationDto{" +
                "aircraft='" + aircraft + '\'' +
                ", engine='" + engine + '\'' +
                ", parameter1Value='" + parameter1Value + '\'' +
                ", parameter2Value='" + parameter2Value + '\'' +
                ", parameter3Value='" + parameter3Value + '\'' +
                ", parameter4Value='" + parameter4Value + '\'' +
                ", parameter5Value='" + parameter5Value + '\'' +
                '}';
    }

}
