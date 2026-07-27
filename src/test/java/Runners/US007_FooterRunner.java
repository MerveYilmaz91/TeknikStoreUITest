package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/US007_FooterMenu.feature",
        glue = "StepDefinitions")

public class US007_FooterRunner extends AbstractTestNGCucumberTests {


}
