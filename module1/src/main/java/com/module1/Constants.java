package com.module1;

public class Constants {

	public Constants() {
		throw new IllegalAccessError ("Utility class");
	}

	public static final String URL_ROOT = "/";

	// Timeout (in milliseconds) of the asynchronous endpoints of the REST Api
	public static final long DEFAULT_MILLISECONDS_TIMEOUT_ASYNCHRONOUS_REST_REQUESTS = 30000;

	// Path of the application
	public static final class APPLICATION_PATH {

		public static final String ROOT = "com.module1";
		public static final String CONTROLLER = ROOT + "." + "controller";
		public static final String REPOSITORY = ROOT + "." + "repository";
		public static final String SCHEDULER  = ROOT + "." + "scheduler";
		public static final String SERVICE    = ROOT + "." + "service";
	}

	// Kafka constants
	public static final String KAFKA_TOPIC = "kafka_topic";

	// Cassandra constants
	public static final String CASSANDRA_KEYSPACE = "cassandra_db";

}
