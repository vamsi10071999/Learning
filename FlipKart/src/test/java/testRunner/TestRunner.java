package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/appFeatures" }, 
			glue = "stepDefinitions",
			plugin = { "pretty", "html:target/CucumberReports/HTMLReport.htlm" }, 
			monochrome = true)

public class TestRunner {

}
