
# API automation framework for SuperHeroes and SuperVillain project

We have used Serenity BDD REST Assured Cucumber framework for API automation. We are verifying status code of all the API's for a positive scenario. In addition to this, we are also validating the JSON schema of all the api response where ever applicable.


## Tools

* Maven
* Cucumber-JVM
* REST assured
* JUnit
* Serenity BDD 
* Serenity HTML reports
* JSON schemas of all the api's are placed under src/test/resources folder for JSON schema validation of API responses.

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
