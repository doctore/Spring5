package com.module2.model;

import com.module2.dto.MeasurementInformationDto;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

/**
 * Measurement data stored in Ignite
 */
public class MeasurementInformation implements Serializable {

    private static final long serialVersionUID = 9143142699265135143L;

    @QuerySqlField(index = true)
    public String aircraft;

    @QuerySqlField
    public String engine;

    @QuerySqlField
    public String parameter1Value;

    @QuerySqlField
    public String parameter2Value;

    @QuerySqlField
    public String parameter3Value;

    @QuerySqlField
    public String parameter4Value;

    @QuerySqlField
    public String parameter5Value;


    public MeasurementInformation (MeasurementInformationDto measurementInformationDto) {

        if (measurementInformationDto != null) {

            aircraft = measurementInformationDto.aircraft;
            engine   = measurementInformationDto.engine;

            parameter1Value = measurementInformationDto.parameter1Value;
            parameter2Value = measurementInformationDto.parameter2Value;
            parameter3Value = measurementInformationDto.parameter3Value;
            parameter4Value = measurementInformationDto.parameter4Value;
            parameter5Value = measurementInformationDto.parameter5Value;
        }
    }


    @Override
    public String toString() {
        return "MeasurementInformation{" +
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
