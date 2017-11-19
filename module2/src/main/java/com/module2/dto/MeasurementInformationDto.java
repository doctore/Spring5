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
    public Integer parameter2Value;
    public String parameter3Value;
    public Double parameter4Value;
    public Boolean parameter5Value;


    @Override
    public boolean equals (Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasurementInformationDto that = (MeasurementInformationDto) o;

        if (!aircraft.equals (that.aircraft)) return false;
        return engine.equals (that.engine);
    }


    @Override
    public int hashCode() {
        int result = aircraft.hashCode();
        result = 31 * result + engine.hashCode();
        return result;
    }


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
