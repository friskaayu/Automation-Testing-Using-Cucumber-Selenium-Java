package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue = {"stepDef"},
//        plugin = { "json:target/cucumber.json", "pretty", "html:target/cucumber-reports" }
        plugin = {"html:target/HTML_report.html"}
)

public class runner {
}
