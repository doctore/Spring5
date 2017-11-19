# Spring5

- [Why this project was created?](#why-this-project-was-created)
- [Projects included in this project](#projects-included-in-this-project)
    - [module1](#module1)
    - [module2](#module2)

## Why this project was created?

This project was born as a proof of concept to learn how to work with the following technologies:

* [Spring 5](https://spring.io)
* [Apache Kafka](http://kafka.apache.org)
* [Apache Cassandra](http://cassandra.apache.org)
* [Apache Ignite](https://ignite.apache.org)

## Projects included in this project

There are two different projects that manage different parts of the flow of the information:

### module1

Asynchronous REST Api and Kafka producer, uses Cassandra to store the information received by web services.

### module2

Kafka consumer, uses Ignite to store in memory the information received by the Kafka producer included in module1.





