package com.module2;

public class Constants {

	public Constants() {
		throw new IllegalAccessError ("Utility class");
	}

	// Path of the application
	public static final class APPLICATION_PATH {

		public static final String ROOT = "com.module2";
		public static final String CONTROLLER = ROOT + "." + "controller";
		public static final String REPOSITORY = ROOT + "." + "repository.impl";
	}

	// Kafka constants
	public static final String KAFKA_TOPIC = "kafka_topic";
	public static final String KAFKA_GROUPID = "kafka_groupoId";

	// Ignite tables
	public static final class IGNITE_TABLES {

		public static final String MEASUREMENT_INFORMATION = "MeasurementInformation";
	}

}
