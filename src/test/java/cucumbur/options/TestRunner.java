package cucumbur.options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/features/placeValidation.feature",
		glue="stepDefinition",
		//tags="@DeletePlace",
		plugin="json:target/jsonReports/report.json"
	
		)
public class TestRunner {

	}

