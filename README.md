
# API automation framework for SuperHeroes and SuperVillain project

We have used Serenity BDD REST Assured Cucumber framework for API automation. Below regression scenarios are covered for all the API's
* Status codes of all the api's for positive flow
* JSON schema validation of all the api's response where ever applicable. JSON Schema validation is achieved by validating with .json files stored in src/test/resources folder
* Creation of user with more than 400 points on the leaderboard 

Below is the structure of the project
* feature file is located under src/test/resources/features folder
* Step definition file/glue file is located under stepDefinition package
* Cucumber runner file file is located under runner package
* API code is located under apiDefinition package
* access token is placed in serenity.conf file which is located under src/test/resources/serenity.conf
* JSON Schema of all the api's are located under src/test/resources folder


## Tools

* Maven
* Cucumber-JVM
* REST assured
* JUnit
* Serenity BDD 

## Requirements

In order to utilise this project you need to have the following installed locally:

* Maven
* Java 1.8 and above


## How to run

* Junit
      * go to src/test/java/runner/ and run class TestSuite.java (will run all testcases)
    
* Maven
      * run command from base project: mvn clean verify (will run all testcases)
     * serenity html report is generated under target/site/serenity/index.html after run


## Reporting

Serenity Report is generated under `/target/site/serenity/index.html` directory after a successful run.

All API results are logged in serenity HTML report along with request and response.
