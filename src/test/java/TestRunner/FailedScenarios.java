package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="@target/rerun.txt",
		glue = "steps"
		, dryRun = false ,
				plugin = {"pretty", "html:target/cucumber","rerun:target/rerun.txt"},//Creates a text file with failed scenarios
		monochrome = true 
		
		)
public class FailedScenarios {
	static{System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111");}
public static void main(String[] args) {
	//System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
}
}