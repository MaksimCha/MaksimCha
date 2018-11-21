package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Titles.DATES_PAGE_TITLE;
import static java.lang.String.valueOf;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DatesPageSelenide {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "div.profile-photo > span")
    private SelenideElement loginTitle;

    @FindBy(css = ".m-l8 [class = 'dropdown-toggle']")
    private SelenideElement serviceButton;

    @FindBy(css = ".m-l8 [href = 'dates.html']")
    private SelenideElement datesButton;

    @FindBy(css = ".ui-slider-handle")
    private List<SelenideElement> sliderItems;

    @FindBy(css = ".ui-slider")
    private SelenideElement mainSlider;

    @FindBy(css = ".logs > li")
    private List<SelenideElement> logs;

    private boolean sideFlag;
    //==============================methods==================================

    @Step
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    @Step
    public void dragAndDropSlider(int fromPosition, int toPosition) {
        double width = mainSlider.getSize().getWidth();
        double sliderWidth = sliderItems.get(0).getSize().getWidth();

        double xSlider = mainSlider.getLocation().getX();
        double xFrom = sliderItems.get(0).getLocation().getX() + sliderWidth / 2;
        double xTo = sliderItems.get(1).getLocation().getX() + sliderWidth / 2;

        double offsetXFrom = xSlider - xFrom + fromPosition * width / 100;
        double offsetXTo = xSlider - xTo + toPosition * width / 100;

        Actions action = new Actions(getWebDriver());
        if (xTo + offsetXTo <= xFrom) {
            action.moveToElement(mainSlider)
                    .dragAndDropBy(sliderItems.get(0), (int) Math.ceil(offsetXFrom), 0)
                    .dragAndDropBy(sliderItems.get(1), (int) Math.ceil(offsetXTo), 0)
                    .perform();
            sideFlag = false;

        } else {
            action.moveToElement(mainSlider)
                    .dragAndDropBy(sliderItems.get(1), (int) Math.ceil(offsetXTo), 0)
                    .dragAndDropBy(sliderItems.get(0), (int) Math.ceil(offsetXFrom), 0)
                    .perform();
            sideFlag = true;
        }
    }

    //==============================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), DATES_PAGE_TITLE.getTitle());
    }

    @Step
    public void checkSliderLogs(int leftPosition, int rightPosition) {
        Iterator<SelenideElement> log = logs.iterator();
        if (sideFlag) {
            checkSliderLog(leftPosition, true, log.next().getText());
            checkSliderLog(rightPosition, false, log.next().getText());
        } else {
            checkSliderLog(rightPosition, false, log.next().getText());
            checkSliderLog(leftPosition, true, log.next().getText());
        }
    }

    private void checkSliderLog(int position, boolean isLast, String expected) {
        String nameSlider = isLast ? "From" : "To";
        assertTrue(expected.contains(nameSlider));
        assertTrue(expected.contains(valueOf(position)));
    }
}
