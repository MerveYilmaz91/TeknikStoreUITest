package Runners;

import Utilities.ConfigReader;

//import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        tags = "",
        features = {"src/test/resources/Features"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class runner extends AbstractTestNGCucumberTests {


// @AfterClass
// public static void writeExtentReport() {

//     ExtentService.getInstance().setSystemInfo("Project Name", ConfigReader.getProperty("projectName"));
//     ExtentService.getInstance().setSystemInfo("Application URL", ConfigReader.getProperty("url"));
//     ExtentService.getInstance().setSystemInfo("Test Type", "SmokeTest");
//     ExtentService.getInstance().setSystemInfo("Framework", "Cucumber BDD + Selenium + TestNG");
//     ExtentService.getInstance().setSystemInfo("Programming Language", "Java");
//
//     ExtentService.getInstance().setSystemInfo("Browser", "Chrome");
//     ExtentService.getInstance().setSystemInfo("Operating System", System.getProperty("os.name"));
//     ExtentService.getInstance().setSystemInfo("OS Version", System.getProperty("os.version"));
//     ExtentService.getInstance().setSystemInfo("Java Version", System.getProperty("java.version"));
//     ExtentService.getInstance().setSystemInfo("User Name", System.getProperty("user.name"));
//     ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//
//     ExtentService.getInstance().setSystemInfo("Tester", "Serkan Sewöster");
//     ExtentService.getInstance().setSystemInfo("Department", "QA");
//     ExtentService.getInstance().setSystemInfo("Environment", "Test Environment");
//     ExtentService.getInstance().setSystemInfo("Tag", "@Regression");
//

}

