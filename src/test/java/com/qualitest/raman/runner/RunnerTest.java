package com.qualitest.raman.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/"},
		plugin = {"pretty", "json:target/cucumber_reports/cucumber.json"},
		glue = {"com.qualitest.raman.stepDefinition"},
		monochrome=true,
		dryRun=false		
)
public class RunnerTest {

}
