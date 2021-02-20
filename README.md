## Cucumber Selenium Java Project

### Overview
Behavioural Driver Framework to test E-commerce Website,
This framework contains automation test pack for MyAccount store

#### Build
Clone the project form below repository:

``https://github.com/raman805551/cucumber-selenium-java-framework.git```
Run the below command to build and download the dependencies required for the project
`mvn clean`
Note: Ensure Maven and Java are configured in local environmental variables 

#### Pre-Requisite
Project is developed with windows chrome (87 version) driver exe file (refer to `/test/resources/driver/chromedriver.exe`),
and this path is setup in `/test/resources/TestData.properties` file under `chrome.driver.path` property.
```Note: please change `chrome.driver.path` to `/test/resources/driver/chromedriver` to run tests in mac chrome (88 version)```

#### Test
Once the build is successful, run the tests using below command,
`mvn clean install`
```Note: By default two scenarios would be picked up for execution```

#### Reports
Please check `TestExutionReports` folder for test execution reports.
Note: under this folder a subfolder will be created with test execution date and time stamp.
eg: TestExutionReports-->Date/time-->cucumber-html-reports-->overview-features.html (open with chrome browser)
Examaple Path: TestExecutionReports/2021.02.20_18-31-27/cucumber-html-reports/overview-features.html

### Developer
Please contact email: `raman.pasala@gmail.com` for any details
