package pe.interbank.bdd.proyecto.StepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:Features",
        glue = "classpath:pe.interbank.bdd.proyecto.StepDefinitions"
                //"classpath:Features"
)

public class TestRunner {
}
