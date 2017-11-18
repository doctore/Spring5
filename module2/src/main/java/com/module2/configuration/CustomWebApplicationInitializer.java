package com.module2.configuration;

import com.module2.configuration.module.IgniteConfig;
import com.module2.configuration.module.KafkaConsumerConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;

/**
 * Used to include and configure the different Spring modules used in the application
 */
public class CustomWebApplicationInitializer implements WebApplicationInitializer {

	/**
	 * Used to change the default configuration of the given {@link ServletContext}
	 *
	 * @param container
	 *    {@link ServletContext} used by the application
	 */
	public void onStartup (ServletContext container) {

		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register (IgniteConfig.class);
		rootContext.register (KafkaConsumerConfig.class);

		// Manage the lifecycle of the root application context
		container.addListener (new ContextLoaderListener (rootContext));
    }
	
}
