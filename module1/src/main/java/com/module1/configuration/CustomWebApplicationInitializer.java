package com.module1.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import com.module1.Constants;
import com.module1.configuration.module.AsyncWebMvcConfigurationSupport;
import com.module1.configuration.module.CassandraConfig;
import com.module1.configuration.module.KafkaProducerConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Used to include and configure the different Spring modules used in the application
 */
public class CustomWebApplicationInitializer implements WebApplicationInitializer {
	
	private final String DEFAULT_SERVLET_NAME = "dispatcher";


	/**
	 * Used to change the default configuration of the given {@link ServletContext}
	 *
	 * @param container
	 *    {@link ServletContext} used by the application
	 */
	public void onStartup (ServletContext container) {

		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register (AsyncWebMvcConfigurationSupport.class);
		rootContext.register (KafkaProducerConfig.class);
		rootContext.register (CassandraConfig.class);

		// Manage the lifecycle of the root application context
		container.addListener (new ContextLoaderListener (rootContext));

		// Create the dispatcher servlet's Spring application context
		ServletRegistration.Dynamic dispatcher = container.addServlet (DEFAULT_SERVLET_NAME, new DispatcherServlet (rootContext));

		// Define the options related with the dispatcher servlet
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping (Constants.URL_ROOT);
		dispatcher.setAsyncSupported (true);
    }
	
}
