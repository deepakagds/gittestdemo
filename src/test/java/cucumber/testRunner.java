package cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue ="stepDefinations",
monochrome = true,tags = "@regression", plugin = {"html:target/cucumber.html"})
public class testRunner extends AbstractTestNGCucumberTests {
}
