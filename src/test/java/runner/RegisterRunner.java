package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Feature",
        glue= "stepdefs"
)
public class RegisterRunner extends AbstractTestNGCucumberTests{
}
