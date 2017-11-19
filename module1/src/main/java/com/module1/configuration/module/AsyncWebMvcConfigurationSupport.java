package com.module1.configuration.module;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.module1.Constants;

/**
 * Used to configure all servlet filters and servlets in the application as asynchronous servlets
 */
@Configuration
@ComponentScan (basePackages = {Constants.APPLICATION_PATH.CONTROLLER
                               ,Constants.APPLICATION_PATH.SERVICE
                               ,Constants.APPLICATION_PATH.SCHEDULER})
@EnableWebMvc
public class AsyncWebMvcConfigurationSupport extends WebMvcConfigurationSupport {
	
	private final String THREAD_GROUP_NAME = "mvc-executor";


    /** {@inheritDoc} */
    @Override
    protected void configureAsyncSupport (AsyncSupportConfigurer configurer) {
    	
        configurer.setDefaultTimeout (Constants.DEFAULT_MILLISECONDS_TIMEOUT_ASYNCHRONOUS_REST_REQUESTS);
        configurer.setTaskExecutor (mvcTaskExecutor());
    }


    /**
     * Configures the {@link ThreadPoolTaskExecutor} used by REST Api endpoints to manage the requests
     *
     * @return {@link ThreadPoolTaskExecutor}
     */
    @Bean
    public ThreadPoolTaskExecutor mvcTaskExecutor() {
    	
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setThreadGroupName (THREAD_GROUP_NAME);
        
        return taskExecutor;
    }

}
