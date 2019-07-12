package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="C:/Users/mukesh/workspace/RestWithCucumber/src/test/java/featureFiles/getPost.feature",
		glue = "steps"
		, dryRun = false ,
				plugin = {"pretty", "html:target/cucumber","rerun:target/rerun.txt"},//Creates a text file with failed scenarios
		monochrome = true 
		
		)
public class TestRunner {

}
