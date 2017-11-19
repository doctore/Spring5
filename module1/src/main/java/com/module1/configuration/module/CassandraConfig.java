package com.module1.configuration.module;

import com.module1.Constants;
import com.module1.enums.ApplicationPropertiesEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories (basePackages = Constants.APPLICATION_PATH.REPOSITORY)
public class CassandraConfig extends AbstractCassandraConfiguration {


    /** {@inheritDoc} */
    @Override
    protected String getKeyspaceName() {
        return Constants.CASSANDRA_KEYSPACE;
    }


    /** {@inheritDoc} */
    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {

        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints (ApplicationPropertiesEnum.CASSANDRA_CONTACT_POINTS.getValue());
        cluster.setPort (ApplicationPropertiesEnum.CASSANDRA_PORT.getValue());

        return cluster;
    }


    /** {@inheritDoc} */
    @Bean
    @Override
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {

        return new CassandraMappingContext();
    }

}
