package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class simpleSiteTesting {

    @Test
    public void simpleTest(){

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1. Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/");

        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4. Assert User name in the left-top side of screen that user is loggined
        WebElement userNameTitle = driver.findElement(By.cssSelector("div.profile-photo > span"));
        assertEquals(userNameTitle.getText(), "PITER CHAILOVSKII");

        //5. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerItem = driver.findElements(By.cssSelector("ul.uui-navigation.nav > li > a"));
        assertEquals(headerItem.get(0).getText(), "HOME");
        assertEquals(headerItem.get(1).getText(), "CONTACT FORM");
        assertEquals(headerItem.get(2).getText(), "SERVICE");
        assertEquals(headerItem.get(3).getText(), "METALS & COLORS");

        //7. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> testedImages = driver.findElements(By.cssSelector("div.benefit-icon > span"));
        for(WebElement image : testedImages){
            assertTrue(image.isDisplayed());
        }

        driver.close();

    }
}
