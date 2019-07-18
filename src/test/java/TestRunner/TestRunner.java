package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="C:\\Users\\mukesh\\workspace\\RestAssuredWithCucumber\\src\\test\\java\\featureFiles\\getPost.feature",
		glue = "steps"
		, dryRun = false ,
				plugin = {"pretty","rerun:target/rerun.txt","html:target/cucumber-html-report","json:target/cucumber.json", "pretty:target/cucumber-pretty.txt","junit:target/cucumber-results.xml"},//Creates a text file with failed scenarios
		monochrome = true 
		
		)
public class TestRunner {

	
}
