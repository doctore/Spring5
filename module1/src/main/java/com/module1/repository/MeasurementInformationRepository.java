package com.module1.repository;

import com.module1.model.MeasurementInformation;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementInformationRepository extends CassandraRepository<MeasurementInformation, String> {}
