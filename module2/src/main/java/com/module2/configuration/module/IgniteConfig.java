package com.module2.configuration.module;

import com.module2.Constants;
import com.module2.model.MeasurementInformation;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.apache.ignite.springdata.repository.support.IgniteRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = {Constants.APPLICATION_PATH.REPOSITORY})
@EnableIgniteRepositories
public class IgniteConfig {

    private final String IGNITE_INSTANCE = "ignite_node";

    /**
     *    Creates an Apache Ignite instance bean. A bean will be passed to {@link IgniteRepositoryFactoryBean}
     * to initialize all Ignite based Spring Data repositories and connect to a cluster.
     */
    @Bean
    public Ignite igniteInstance() {

        IgniteConfiguration cfg = new IgniteConfiguration();

        // Setting some custom name for the node
        cfg.setIgniteInstanceName (IGNITE_INSTANCE);

        // With it we don't have to manually deploy our Java code on each node in the grid and re-deploy it each time it changes
        cfg.setPeerClassLoadingEnabled (true);

        // The ignite server daemon should be launched previously
        cfg.setClientMode (true);

        // Load the tables, indexes, etc that we want to include in Ignite
        cfg.setCacheConfiguration (configureIgnititeTables());

        return Ignition.start (cfg);
    }


    /**
     * Configure the ignite tables definitions
     *
     * @return an array of {@link CacheConfiguration} with the table's configuration
     */
    private CacheConfiguration[] configureIgnititeTables() {

        // Defining and creating a new cache table to be used by Ignite
        CacheConfiguration ccfgMI = new CacheConfiguration (Constants.IGNITE_TABLES.MEASUREMENT_INFORMATION);

        // Setting SQL index for the new cache table
        ccfgMI.setIndexedTypes (String.class, MeasurementInformation.class);

        return new CacheConfiguration[] { ccfgMI };
    }

}
