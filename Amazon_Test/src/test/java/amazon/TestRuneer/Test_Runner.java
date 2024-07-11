package amazon.TestRuneer;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Amazon_Test/src/test/java/amazon/Features/Login_Page.feature", //the path of the feature files
		glue={"/Amazon_Test/src/test/java/amazon/StepDefs/Login_Page_StepDefs.java"}, //the path of the step definition files
		format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false //to check the mapping is proper between feature file and step def file			
		)


public class Test_Runner {

}
