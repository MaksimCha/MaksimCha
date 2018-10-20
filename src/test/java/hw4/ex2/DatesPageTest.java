package hw4.ex2;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Titles.HOME_PAGE_TITLE;
import static enums.Titles.LOGIN_TITLE;
import static enums.Users.PITER_CHALOVSKII;

public class DatesPageTest extends SelenideTestBase {

    private DatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @Test
    public void simpleTest() {

        //1. Open test site by URL
        datesPageSelenide.openPage();

        //2. Assert Browser title
        datesPageSelenide.checkTitle(HOME_PAGE_TITLE.title);

        //3. Perform login
        datesPageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        datesPageSelenide.checkLoginTitle(LOGIN_TITLE.title);

        //5. Open through the header menu Service -> Dates Page
        datesPageSelenide.realiseDatesButton();
        datesPageSelenide.checkDatesPageDisplaying();

        //6. Using drag-and-drop set Range sliders.
        // left sliders - the most left position,
        // right slider - the most rigth position

    }
}
