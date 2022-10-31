
Test Automation using **Selenium**, **Cucumber**, **JUnit**, **Maven**, and **Java Language** with **Page Object Model with the help of PageFactory**

## Browser Supported & Tested
 > Chrome

## ChromeDriver [Important]
* Chrome driver for mac OS is copied under folder `resources/driver`
  if you wish to use a different OS, please download and copy the driver under `resources/driver` folder
  and rename as "chrome"
* Get [ChromeDriver](https://sites.google.com/chromium.org/driver/) here

### project related setup and other Configuration
* Browser name, Wait time, URL etc are present in config.properties file under project directory
* Report configuration is available in extent.properties under src/test/resources folder.

## Coverage
###### 1. Test cases  - written using Gherkin language and added as .feature file in features folder
###### 2.Step implementation - available in Step Definition folder
###### 3.Selenium locators added in com.singtel.pageobjects package

## How to Execute?

#### 1. Run the Test
* You are ready to automate the test in [ToDo](https://todomvc.com/examples/vue)
* Run your test using `mvn install` or `mvn test` from Terminal

#### 2. Test Result
* Reports will be available under `test-output` folder in the project folder
* Available Report formats - Html Report, JsonReport, SparkReport, PdfReport

