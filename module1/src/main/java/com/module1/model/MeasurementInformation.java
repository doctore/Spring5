package com.module1.model;

import com.module1.dto.MeasurementInformationDto;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * Measurement data stored in Cassandra
 */
@Table("MeasurementInformation")
public class MeasurementInformation {

    @PrimaryKeyColumn (name = "aircraft", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String aircraft;

    @PrimaryKeyColumn (name = "engine", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String engine;

    private String parameter1Value;

    private Integer parameter2Value;

    private String parameter3Value;

    private Double parameter4Value;

    private Boolean parameter5Value;


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

    public String getAircraft() {
        return aircraft;
    }
    public void setAircraft (String aircraft) {
        this.aircraft = aircraft;
    }

    public String getEngine() {
        return engine;
    }
    public void setEngine (String engine) {
        this.engine = engine;
    }

    public String getParameter1Value() {
        return parameter1Value;
    }
    public void setParameter1Value (String parameter1Value) {
        this.parameter1Value = parameter1Value;
    }

    public Integer getParameter2Value() {
        return parameter2Value;
    }
    public void setParameter2Value (Integer parameter2Value) {
        this.parameter2Value = parameter2Value;
    }

    public String getParameter3Value() {
        return parameter3Value;
    }
    public void setParameter3Value (String parameter3Value) {
        this.parameter3Value = parameter3Value;
    }

    public Double getParameter4Value() {
        return parameter4Value;
    }
    public void setParameter4Value (Double parameter4Value) {
        this.parameter4Value = parameter4Value;
    }

    public Boolean getParameter5Value() {
        return parameter5Value;
    }
    public void setParameter5Value (Boolean parameter5Value) {
        this.parameter5Value = parameter5Value;
    }


    @Override
    public boolean equals (Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasurementInformation that = (MeasurementInformation) o;

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
