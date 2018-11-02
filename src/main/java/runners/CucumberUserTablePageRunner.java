package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

@CucumberOptions(
        features = "src/test/java",
        glue = "pageObjects",
        tags = "@userTest")
public class CucumberUserTablePageRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite(){
        Configuration.browser = "chrome";
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}
