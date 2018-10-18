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

import static enums.Users.PITER_CHAILOWSKI;

public class PageObjectTest extends TestBase {

    private WebDriver driver;
    private TestedPage testedPage;

    //TODO enum
    private final String MAIN_HEADER_TITLE = "EPAM FRAMEWORK WISHES…";
    private final String MAIN_HEADER_TEXT =
            "LOREM IPSUM DOLOR SIT AMET, " +
                    "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                    "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
                    "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT " +
                    "DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM " +
                    "DOLORE EU FUGIAT NULLA PARIATUR.";
    private final String LOGIN_TITLE = "PITER CHAILOVSKII";
    private final String FIRST_IMAGE_TITLE =
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM project";
    private final String SECOND_IMAGE_TITLE =
            "To be flexible and\n" +
                    "customizable";
    private final String THIRD_IMAGE_TITLE = "To be multiplatform";
    private final String FOURTH_IMAGE_TITLE =
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…";

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
        testedPage.checkTitle(driver, "Home Page");

        //3. Login
        testedPage.login(PITER_CHAILOWSKI.login, PITER_CHAILOWSKI.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        testedPage.checkLoginTitle(LOGIN_TITLE);

        //5. Assert Browser title
        testedPage.checkTitle(driver, "Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        ArrayList<String> expectedTitles = new ArrayList<String>();
        expectedTitles.add("HOME");
        expectedTitles.add("CONTACT FORM");
        expectedTitles.add("SERVICE");
        expectedTitles.add("METALS & COLORS");

        testedPage.checkHeaderItemText(expectedTitles);

        //7. Assert that there are 4 images on the Index Page and they are displayed
        testedPage.checkIndexPageImages();

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        ArrayList<String> expectedImageTitles = new ArrayList<String>();
        expectedImageTitles.add(FIRST_IMAGE_TITLE);
        expectedImageTitles.add(SECOND_IMAGE_TITLE);
        expectedImageTitles.add(THIRD_IMAGE_TITLE);
        expectedImageTitles.add(FOURTH_IMAGE_TITLE);

        testedPage.checkImageTitles(expectedImageTitles);

        //9. Assert a text of the main header
        testedPage.checkMainHeaderText(MAIN_HEADER_TITLE,
                MAIN_HEADER_TEXT);

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
        testedPage.checkSubHeaderLink("https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        testedPage.checkLeftSectionDisplaying();

        //16. Assert that there is Footer
        testedPage.checkFooterDisplaying();
    }
}
