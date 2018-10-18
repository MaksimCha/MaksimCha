package hw3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.TestedPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static enums.Titles.*;
import static enums.Users.PITER_CHAILOWSKI;

public class PageObjectTest extends TestBase {

    private WebDriver driver;
    private TestedPage testedPage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        testedPage = PageFactory.initElements(driver, TestedPage.class);
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

        //1. Navigate
        testedPage.open(driver);

        //2. Assert
        testedPage.checkTitle(driver, HOME_PAGE_TITLE.title);

        //3. Login
        testedPage.login(PITER_CHAILOWSKI.login, PITER_CHAILOWSKI.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        testedPage.checkLoginTitle(LOGIN_TITLE.title);

        //5. Assert Browser title
        testedPage.checkTitle(driver, HOME_PAGE_TITLE.title);

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        ArrayList<String> expectedTitles = new ArrayList<String>();
        expectedTitles.add(FIRST_HEADER_ITEM_TITLE.title);
        expectedTitles.add(SECOND_HEADER_ITEM_TITLE.title);
        expectedTitles.add(THIRD_HEADER_ITEM_TITLE.title);
        expectedTitles.add(FOURTH_HEADER_ITEM_TITLE.title);

        testedPage.checkHeaderItemText(expectedTitles);

        //7. Assert that there are 4 images on the Index Page and they are displayed
        testedPage.checkIndexPageImages();

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        ArrayList<String> expectedImageTitles = new ArrayList<String>();
        expectedImageTitles.add(FIRST_IMAGE_TITLE.title);
        expectedImageTitles.add(SECOND_IMAGE_TITLE.title);
        expectedImageTitles.add(THIRD_IMAGE_TITLE.title);
        expectedImageTitles.add(FOURTH_IMAGE_TITLE.title);

        testedPage.checkImageTitles(expectedImageTitles);

        //9. Assert a text of the main header
        testedPage.checkMainHeaderText(MAIN_HEADER_TITLE.title,
                MAIN_HEADER_TEXT.title);

        //10. Assert that there is the iframe in the center of page
        testedPage.checkFrameDisplaying();

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        testedPage.switchToMainFrame(driver);
        testedPage.checkFrameLogo(driver);

        //12. Switch to original window back
        testedPage.switchToParentFrame(driver);

        //13. Assert a text of the sub header
        testedPage.checkSubHeaderDisplaying();

        //14. Assert that JDI GITHUB is a link and has a proper URL
        testedPage.checkSubHeaderLink(SUBHEADER_LINK.title);

        //15. Assert that there is Left Section
        testedPage.checkLeftSectionDisplaying();

        //16. Assert that there is Footer
        testedPage.checkFooterDisplaying();
    }
}
