package hw3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static enums.Titles.*;
import static enums.Users.PITER_CHALOVSKII;

public class PageObjectTest extends TestBase {

    private WebDriver driver;
    private HomePageSelenium homePageSelenium;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePageSelenium = PageFactory.initElements(driver, HomePageSelenium.class);
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
    public void homePageTest() {

        //1. Navigate
        homePageSelenium.open(driver);

        //2. Assert
        homePageSelenium.checkTitle(driver, HOME_PAGE_TITLE.getTitle());

        //3. Login
        homePageSelenium.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSelenium.checkLoginTitle(LOGIN_TITLE.getTitle());

        //5. Assert Browser title
        homePageSelenium.checkTitle(driver, HOME_PAGE_TITLE.getTitle());

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts

        homePageSelenium.checkHeaderItemText();

        //7. Assert that there are 4 images on the Index Page and they are displayed
        homePageSelenium.checkIndexPageImages();

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSelenium.checkImageTitles();

        //9. Assert a text of the main header
        homePageSelenium.checkMainHeaderText(MAIN_HEADER_TITLE.getTitle(),
                MAIN_HEADER_TEXT.getTitle());

        //10. Assert that there is the iframe in the center of page
        homePageSelenium.checkFrameDisplaying();

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePageSelenium.switchToMainFrame(driver);
        homePageSelenium.checkFrameLogo(driver);

        //12. Switch to original window back
        homePageSelenium.switchToParentFrame(driver);

        //13. Assert a text of the sub header
        homePageSelenium.checkSubHeaderDisplaying();

        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePageSelenium.checkSubHeaderLink(SUBHEADER_LINK.getTitle());

        //15. Assert that there is Left Section
        homePageSelenium.checkLeftSectionDisplaying();

        //16. Assert that there is Footer
        homePageSelenium.checkFooterDisplaying();
    }
}
