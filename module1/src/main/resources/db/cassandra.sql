CREATE KEYSPACE cassandra_db WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE cassandra_db;

CREATE TABLE IF NOT EXISTS MeasurementInformation (
   aircraft         VARCHAR
  ,engine           VARCHAR
  ,parameter1Value  VARCHAR
  ,parameter2Value  INT
  ,parameter3Value  VARCHAR
  ,parameter4Value  DOUBLE
  ,parameter5Value  BOOLEAN
  ,PRIMARY KEY (aircraft, engine));
