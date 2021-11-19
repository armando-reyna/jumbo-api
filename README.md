# Coding Assignment
## Jumbo API

### Objective
Create an application that shows the 5 closest Jumbo stores to a given position.

### Overview
The solution is a Spring Boot Application API that exposes a store endpoint that receives a position and returns the Jumbo closest stores.
The solution contains an Embedded MongoDB database that uses the provided json as a datasource, `RepositoryAutoPopulator` inserts the store records when the app initializes.

### Prerequisites
* [Java](https://www.oracle.com/java/technologies/downloads) version 11

### How to run
* execute `./mvnw spring-boot:run`

### Execute tests
* execute `./mvnw clean test`

### Manual tests
* execute `curl http://localhost:8080/api/v1/store/closest/{number of stores to retrieve}/{latitude}/{longitude}`
* example `curl http://localhost:8080/api/v1/store/closest/5/51.399843/5.469597`
