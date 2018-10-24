package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

@CucumberOptions(
        features = "src/test/java",
        glue = "pageObjects",
        tags = "@smokeTest")
public class CucumberServicePageRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite(){
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
        Configuration.browserSize = "1920x1080";
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}
