# Spring5

- [Why was this project created?](#why-was-this-project-created)
- [Modules included in this project](#modules-included-in-this-project)
    - [module1](#module1)
    - [module2](#module2)
- [Flow example](#flow-example)

## Why was this project created?

This project was born as a proof of concept to learn how to work with the following technologies:

* [Spring 5](https://spring.io)
* [Apache Kafka](http://kafka.apache.org)
* [Apache Cassandra](http://cassandra.apache.org)
* [Apache Ignite](https://ignite.apache.org)

## Modules included in this project

There are two different ones that manage different parts of the flow of the information:

### module1

Asynchronous REST Api and Kafka producer, uses Cassandra to store the information received by web services.

### module2

Kafka consumer, uses Ignite to store in memory the information received by the Kafka producer included in **module1**.

## Flow example

Once we have installed the required libraries/databases to start to work. We can use the web service defined in **module1**:

* *URL (in localhost):* http://localhost:8080/module1/measurementInformation
* *REST operator:* POST
* *Json data:* (see **MeasurementInformationDto** to know the required data)

Managed by **MeasurementInformationController.addMeasurementInformation** method to start with the flow.

The next step is managed by **MeasurementInformationServiceImpl.addMeasurementInformation**, this method stores the given information in Cassandra and uses Kafka
to send it to **module2**.

Now, in **module2**, the information is received by **MeasurementInformationController.newMeasurementInformationListener** (a Kafka consumer) that stores it in Ignite.







