package Task3;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.HomePage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SimpleTestPageObject extends TestBase {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void simpleTest() {

        //TODO Business logic
        WebDriver driver1 = new ChromeDriver();
        //2. Navigate
        //homePage.open(driver1);

        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3. Assert
        //homePage.checkTitle(driver1);

        assertEquals(driver.getTitle(), "Home Page");

        //4. Login
        homePage.login("epam", "1234");

        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
    }
}
