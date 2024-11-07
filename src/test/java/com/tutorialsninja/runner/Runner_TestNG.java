package com.tutorialsninja.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue =  "com.tutorialsninja.Step_Definition",
        tags = "@ValidCredentials",
        monochrome = true,
        plugin = {"pretty", "html:target/site/cucumber/cucumber-html", "json:target/cucumber1.json"}
)

public class Runner_TestNG extends AbstractTestNGCucumberTests {

}
