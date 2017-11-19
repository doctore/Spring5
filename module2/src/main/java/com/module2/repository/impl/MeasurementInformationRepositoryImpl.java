package com.module2.repository.impl;

import com.module2.Constants;
import com.module2.model.MeasurementInformation;
import com.module2.repository.MeasurementInformationRepository;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MeasurementInformationRepositoryImpl extends IgniteRepositoryImpl<MeasurementInformation, String>
                                                  implements MeasurementInformationRepository {

    @PostConstruct
    public void postInitialization() {
        cache = igniteInstance.cache (Constants.IGNITE_TABLES.MEASUREMENT_INFORMATION);
    }


    /**
     * Retrieves the values of the parameters belonging to the given id
     *
     * @param aircraft must not be {@literal null}
     * @return values of the parameters
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    public List<String> getParameterValues (String aircraft) {

        if (aircraft == null)
            throw new IllegalArgumentException ("Given aircraft is null");

        // Querying data from the cluster using a distributed JOIN.
        SqlFieldsQuery query = new SqlFieldsQuery ("SELECT parameter1Value, parameter2Value "
                                                 + "      ,parameter3Value, parameter4Value, parameter5Value "
                                                 + "FROM " + Constants.IGNITE_TABLES.MEASUREMENT_INFORMATION + " "
                                                 + "WHERE aircraft = ?").setArgs (aircraft);
        List<String> result = new ArrayList<>();
        cache.query (query).getAll().forEach (r -> {
            result.add ((String)r.get(0));
            result.add ((String)r.get(1));
            result.add ((String)r.get(2));
            result.add ((String)r.get(3));
            result.add ((String)r.get(4));
        });
        return result;
    }

}
