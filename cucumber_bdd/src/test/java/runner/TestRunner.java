package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features/TutorialNinja.feature",
        glue = {"stepdefinitions","Hooks"},
        		tags = "@Smoke",
        plugin = {"pretty","html:target/htmlreport/report1.html",
        		"json:target/jsonreport/report",
        		"junit:target/junitreport/report"}
)

public class TestRunner {

}


