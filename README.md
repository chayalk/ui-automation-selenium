# UI Automation Framework - Selenium & TestNG
## About the repository
Contains a UI Automation Framework which demonstrates sample UI automation scripts which tests the login
and add to Cart scenarios which targets the practice website https://www.saucedemo.com/.

## Tools and Frameworks used
- Selenium
- TestNG
- ExtentReports

## Prerequisites
Configure Java and Maven in the development environment that you are planning to run the tests

## Running the tests

### Run all tests from command line
```sh
mvn clean test
```
### Run specific test suite
```sh
mvn clean test -DtestngXmlFile="PATH_TO_TESTNG_XML"
```
### Via IDE
Right click on a TestNG xml file and click run.

## Reports
A report is generated using the Extent report library and can be located in the below location.
- target/reports/api-Report.html

