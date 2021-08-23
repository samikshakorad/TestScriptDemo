package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 

@RunWith(Cucumber.class)
@CucumberOptions
(
		features= {".//features/login.feature"},
		glue="stepDefinitions",
		monochrome=true,
		dryRun=false
)
	
public class testRun {

}
