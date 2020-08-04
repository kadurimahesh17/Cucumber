package runners;

import java.io.File;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
        features = "src/test/resources/FeatureFiles",
        glue = "steps",
        tags = {"@Book_Tikect"}        
        )
public class Runner extends AbstractTestNGCucumberTests{

	    @AfterClass
	    public static void teardown() {
	        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	        Reporter.setSystemInfo("user", System.getProperty("user.name"));
	        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	        Reporter.setSystemInfo("os", "os.name");
	        Reporter.setTestRunnerOutput("Cucumber report");
	    }

}
