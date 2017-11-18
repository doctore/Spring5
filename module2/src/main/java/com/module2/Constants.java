package com.module2;

public class Constants {

	public Constants() {
		throw new IllegalAccessError ("Utility class");
	}

	// Path of the application
	public static final class APPLICATION_PATH {

		public static final String ROOT = "com.module2";
		public static final String REPOSITORY = ROOT + "." + "repository.impl";
		public static final String SERVICE = ROOT + "." + "service";
	}

	// Kafka constants
	public static final String KAFKA_TOPIC = "learning";
	public static final String KAFKA_GROUPID = "group1";

	// Ignite tables
	public static final class IGNITE_TABLES {

		public static final String MEASUREMENT_INFORMATION = "MeasurementInformation";
	}

}
