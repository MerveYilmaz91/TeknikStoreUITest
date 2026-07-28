package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/US016_WhatsAppLink.feature",
        glue = "StepDefinitions")

public class US016_WhatsAppHeaderRunner extends AbstractTestNGCucumberTests {
}
