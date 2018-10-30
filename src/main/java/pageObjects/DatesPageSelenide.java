package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.Double.parseDouble;
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

    @FindBy(css = "a.ui-corner-all")
    private List<SelenideElement> sliderItems;

    @FindBy(css = "div.ui-widget-content")
    private SelenideElement mainSlider;

    @FindBy(css = ".panel-body-list.logs > li")
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
    public void datesButtonClick() {
        serviceButton.click();
        datesButton.click();
    }

    @Step
    public void dragAndDropSlider(int fromPosition, int toPosition) {
        double width = (double) mainSlider.getSize().width;
        Double currentLeftPosition = parseDouble(sliderItems
                .get(0)
                .getCssValue("left")
                .replaceAll("px", "")) / (width / 100);
        Double currentRightPosition = parseDouble(sliderItems
                .get(1)
                .getCssValue("left")
                .replaceAll("px", "")) / (width / 100);
        if(currentLeftPosition.equals(currentRightPosition)){
            if(fromPosition > currentRightPosition){
                setSliderPosition(fromPosition, sliderItems.get(1));
                setSliderPosition(toPosition, sliderItems.get(0));
                sideFlag = true;
            }
            if(toPosition < currentLeftPosition) {
                setSliderPosition(fromPosition, sliderItems.get(0));
                setSliderPosition(toPosition, sliderItems.get(1));
                sideFlag = false;
            }
        }else{
            setSliderPosition(fromPosition, sliderItems.get(0));
            setSliderPosition(toPosition, sliderItems.get(1));
            sideFlag = false;
        }
    }

    @Step
    private void setSliderPosition(Integer position, SelenideElement sliderItem) {
        double width = (double) mainSlider.getSize().width;
        Actions act = new Actions(getWebDriver());
        Double currentPosition = parseDouble(sliderItem.getCssValue("left").replaceAll("px", "")) / (width / 100);
        int xOffset = (int) ((position - currentPosition - 1) * (width / 100));
        act.dragAndDropBy(sliderItem, xOffset, 0).build().perform();
    }

    //==============================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Dates");
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

    @Step
    private void checkSliderLog(int position, boolean isLast, String expected) {
        String nameSlider = isLast ? "From" : "To";
        assertTrue(expected.contains(nameSlider));
        assertTrue(expected.contains(valueOf(position)));
    }
}
