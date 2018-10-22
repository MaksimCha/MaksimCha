package hw4.ex2;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Titles.LOGIN_TITLE;
import static enums.Users.PITER_CHALOVSKII;

public class DatesPageTest extends SelenideTestBase {

    private DatesPageSelenide datesPageSelenide;
    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @Test
    public void simpleTest() {

        //1. Open test site by URL
        homePageSelenide.openPage();

        //2. Assert Browser title
        homePageSelenide.checkTitle();

        //3. Perform login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkLoginTitle(LOGIN_TITLE.title);

        //5. Open through the header menu Service -> Dates Page
        datesPageSelenide.realiseDatesButton();
        datesPageSelenide.checkTitle();

        //6. Using drag-and-drop set Range sliders.
        // left sliders - the most left position,
        // right slider - the most right position
        datesPageSelenide.dragAndDropSlider(0, 100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values

        //8. Using drag-and-drop set Range sliders.
        // left sliders - the most left position,
        // right slider - the most left position.
        datesPageSelenide.dragAndDropSlider(0, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values

        //10. Using drag-and-drop set Range sliders.
        // left sliders - the most right position,
        // right slider - the most right position.
        datesPageSelenide.dragAndDropSlider(100, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values

        //12. Using drag-and-drop set Range sliders.
        datesPageSelenide.dragAndDropSlider(30, 70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
    }
}
