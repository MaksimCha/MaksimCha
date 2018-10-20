package task4;

import base.SelenideTestBase;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import listeners.AllureAttachmentListener;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.HomePageSelenide;

import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

@Feature("Smoke tests")
@Story("Home page testing")
@Listeners(AllureAttachmentListener.class)
public class SimpleTestSelenidePageObject extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Issue("IGRT-192")
    @Flaky
    @TmsLink("")
    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //Navigate
        homePageSelenide.openPage();

        //Assert
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //Login
        $(".profile-photo").click();
        $("[id = 'Name']").sendKeys("epam");
        $("[id = 'Password']").sendKeys("1234");
        $(".login [type = 'submit']").click();

        SelenideElement mainTitle = $("h3.main-title");
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));

        //$$(By.xpath("//*")).shouldHaveSize(4);
        //$$(By.xpath("//*")).shouldBe(sizeLessThan(5));
    }
}
