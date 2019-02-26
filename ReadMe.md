# Spring Benchmark: Reactive vs. Non-Reactive

This code is intended to measure the performance benefits of a web application using Spring Reactive Idioms
with MongoDB as the backend datastore. MongoDB was chosen as non-blocking operations are already supported by corresponding driver.

This project consists of 3 folders:
- non-reactive (webapp using Spring MVC idioms)
- reactive (webapp using Spring Reactive Idioms)
- gatling-performance (sets up a scenario to test perfromance)

Both webapps have the same domain (a person with name and appelation) and the same endpoints.
The only difference is that one is using  `ReactiveMongoRepository` and the other a `MongoRepository`.
In order to get those two webapps up and running you need a local MongoDB running. Otherwise you will need to edit the according application.yaml
in order to point the webapp to yout MongoDB instance.
The non-reactive project contains in its test folder the class `Databasepopulator` which you can run to pump 20000
person records in to the database.

### Starting the Benchmark

- Start the webapp you want to benchmark (either by clicking *play* in the IDE or by spinning up a gradle task)
- Set the following environment variables to parameterize the test:
    - USERS (Number of users which each sends 1000 requests)
    - DURATION (at most this amount of time the test scenario will run)
    - URL (the url constantly called)
    - TESTNAME (Give the test a meningful name such that you can identify what you've done later on)
- Then run gradle loadTest in the gatling-performance folder.

To test the reactive wbeapps endpoint which returns all persons whose appelattino starts with a given prefix you set  
 ['USERS': '30', 'DURATION': '10', 'TESTNAME': 'Reactive-Test-Get', 'URL': 'http://localhost:12051/person/starts/j'].  
 Then run gradle loadTestGet.

To test the reactive wbeapps endpoint which creates random persons  
 ['USERS': '30', 'DURATION': '10', 'TESTNAME': 'Reactive-Test-Post', 'URL': 'http://localhost:12051/person/starts/j'].  
 Then run gradle loadTestPost.
 
 