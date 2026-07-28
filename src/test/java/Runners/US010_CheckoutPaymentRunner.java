package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/US010_CheckoutPaymentPage.feature",
        glue = "StepDefinitions")

public class US010_CheckoutPaymentRunner extends AbstractTestNGCucumberTests {
}
