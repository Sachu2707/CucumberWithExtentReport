package com.runnerClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "@ValidCredentials", features = "src/test/resources/features/SampleTest.feature", glue = "com.example.definitions",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
 
}