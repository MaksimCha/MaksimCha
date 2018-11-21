package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.CheckBoxItems;
import enums.DropDownItems;
import enums.RadioButtonItems;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Titles.DIFEL_PAGE_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementPageSelenide {

    @FindBy(css = ".label-checkbox > input")
    private List<SelenideElement> checkBoxesInputs;

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> checkBoxes;

    @FindBy(css = ".label-radio > input")
    private List<SelenideElement> radioButtons;

    @FindBy(css = "option")
    private List<SelenideElement> dropDownItems;

    @FindBy(css = ".colors")
    private SelenideElement dropDown;

    @FindBy(css = ".main-content-hg .uui-button")
    private List<SelenideElement> buttons;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement lightSection;

    @FindBy(css = ".panel-body-list.logs > li")
    private List<SelenideElement> logs;

    //==============================methods==================================

    @Step
    public void selectCheckBoxes(CheckBoxItems... items) {
        for (CheckBoxItems item : items) {
            assertTrue(checkBoxesInputs.size() >= item.counter);
            iterateButtons(item.counter, checkBoxesInputs);
        }
    }

    @Step
    public void selectRadioButton(RadioButtonItems item) {
        assertTrue(radioButtons.size() >= item.counter);
        iterateButtons(item.counter, radioButtons);
    }

    @Step
    public void selectDropDownButton(DropDownItems item) {
        assertTrue(dropDownItems.size() >= item.counter);
        iterateButtons(item.counter, dropDownItems);
    }

    private void iterateButtons(int count, List<SelenideElement> items) {
        int i = 0;
        for (SelenideElement item : items) {
            if (i == count) {
                item.click();
            }
            ++i;
        }
    }

    private void iterateCheckBoxes(CheckBoxItems item, String expected, boolean isChecked) {
        for (SelenideElement checkBox : checkBoxes) {
            if (checkBox.getText().equalsIgnoreCase(item.value)) {
                checkCheckBoxLog(item.value, isChecked, expected);
            }
        }
    }

    //==============================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), DIFEL_PAGE_TITLE.getTitle());
    }

    @Step
    public void checkDifElPageExists() {
        checkCheckBoxes();
        checkRadios();
        checkDropDown();
        checkButtons();
    }

    private void checkRadios() {
        for (SelenideElement RadioButton : radioButtons) {
            RadioButton.shouldBe(visible);
        }
    }

    private void checkCheckBoxes() {
        for (SelenideElement CheckBox : checkBoxesInputs) {
            CheckBox.shouldBe(visible);
        }
    }

    private void checkDropDown() {
        dropDown.shouldBe(visible);
    }

    private void checkButtons() {
        for (SelenideElement Button : buttons) {
            Button.shouldBe(visible);
        }
    }

    @Step
    public void checkRightSection() {
        lightSection.shouldBe(visible);
    }

    @Step
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    public void checkCheckBoxesLogs(boolean isChecked, CheckBoxItems... items) {
        Iterator<SelenideElement> log = logs.iterator();
        for (CheckBoxItems item : items) {
            iterateCheckBoxes(item, log.next().getText(), isChecked);
        }
    }

    private void checkCheckBoxLog(String value, boolean isChecked, String expected) {
        assertTrue(expected.contains(value));
        assertTrue(expected.contains(String.valueOf(isChecked)));
    }

    private void checkLog(String value) {
        String lastLogText = logs.get(0).getText();
        assertTrue(lastLogText.contains(value));
    }

    @Step
    public void checkRadioButtonLog(RadioButtonItems item) {
        checkLog(item.value);
    }

    @Step
    public void checkDropDownLog(DropDownItems item) {
        checkLog(item.value);
    }
}
