package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "definitions",
        plugin = {
                "pretty",  // Prints steps in readable format in console
                "html:target/cucumber-reports/CucumberReport.html",  // Generates an HTML report
                "json:target/cucumber-reports/CucumberReport.json",  // Generates a JSON report
                "junit:target/cucumber-reports/CucumberReport.xml"  // Generates a JUnit XML report
        },
        monochrome = true  // Ensures readable console output
)

public class TestRunner {

}
