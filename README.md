# BDD Cucumber Framework

This repository provides some working boilerplate code for building automated test suites for UI-based testing with Selenium 3 and Behavior driven development (BDD).

# Below are some of the features of this test framework:

* Maven based framework
* Web Driver Manager - remove complete dependency of Operating system (OS) no need to maintain drivers with respect to OS (for e.g. Windows OS needs driver with '.exe' extension for linux or macos '.exe' will not work that's why we have to keep maintain all driver on the project)
* Extent Report for reporting
* Report Generation (cucumber-reporting)
* Helper class to handle web component such as (click,sendkeys etc)
* POM with page factory (Page Object Model is a design pattern to create Object Repository for web UI elements. Page Factory is an inbuilt Page Object Model concept for Selenium WebDriver but it is very optimized.)
* Different browser support (chrome,firefox)
* Java 8 (lambda expression)
* Added tag for each scenario to differentiate between sanity test and regression test

# Documentation

* [Installation](https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/doc/installation.md)
* [Install IntelliJ](https://www.jetbrains.com/idea/download/#section=linux) for easy use of lambda expression
* Configure and Install Following Intellij Plugins
    * File -> Setting -> Plugins ->
    * Cucumber for Java
    * Gherkin
    * Maven Integration

# Setting up and running tests

* Go to Project >src >test >java >runner>TestRunner
    * Right click on it and run project

* Run project on headless mode on local
    * mvn clean compile test -Denv='server'

* Run project on window mode on local
    * mvn clean compile test  -Denv='local'

* Run project on window mode with sanity tag
    * mvn clean compile test  -Denv='local' -DCucumber.options="--tags @sanity"

* Run project on window mode with regression tag
    * mvn clean compile test  -Denv='local' -DCucumber.options="--tags @regression"

* Run project on chrome browser by passing browser name at run time
    * mvn clean compile test  -Denv='local' -Dbrowser="chrome"

* Run project on firefox browser by passing browser name at run time
    * mvn clean compile test  -Denv='local' -Dbrowser="firefox"

