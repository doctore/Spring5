package com.module2.enums;

import java.util.ResourceBundle;


/**
 * Stores the values of every property of application.properties file used in the application
 */
public enum ApplicationPropertiesEnum implements ManagePropertiesFilesWithEnumsInterface {

    // URL on which the Kafka server is running
    KAFKA_SERVER ("kafka.server") {

        @Override
        public String getValue() {
            return applicationBundle.getString (this.getPropertyName());
        }
    };


    private String propertyName;

    ApplicationPropertiesEnum (String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    // Load application.properties file
    private static ResourceBundle applicationBundle = ResourceBundle.getBundle ("application");
}


/**
 * Used to work with properties files using java enums
 */
interface ManagePropertiesFilesWithEnumsInterface {

    /**
     * Returns the value of a property in the file related to the current enum value
     *
     * @return value of a property in a properties file
     */
    public <T> T getValue();
}
