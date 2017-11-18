package com.module2.repository;

import com.module2.Constants;
import com.module2.model.MeasurementInformation;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import java.util.List;

@RepositoryConfig (cacheName = Constants.IGNITE_TABLES.MEASUREMENT_INFORMATION)
public interface MeasurementInformationRepository extends IgniteRepository<MeasurementInformation, String> {

    /**
     * Retrieves the values of the parameters belonging to the given id
     *
     * @param id must not be {@literal null}
     * @return values of the parameters
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    List<String> getParameterValues (String id);

}
