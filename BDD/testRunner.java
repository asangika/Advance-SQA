package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"stepDefinitions"})
public class testRunner { 

}
