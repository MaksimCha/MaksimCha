package hw2.ex1;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.assertEquals;

public class ParallelDataProviderImageTest extends TestBase {

    private AtomicInteger threadSize = new AtomicInteger(0);

    @Test(dataProvider = "testDataProvider", dataProviderClass = TestDataProvider.class, threadPoolSize = 4)
    public void textImageTesting(String text, int i) {

        System.out.println(threadSize.incrementAndGet());

        //1. Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3. Assert 4 texts below 4 pictures on the Index Page
        List<WebElement> testedText = driver.findElements(By.cssSelector("div.benefit > span"));
        assertEquals(testedText.get(i).getText(), text);

        //4. Close driver
        driver.close();
    }
}
