package pageObjects;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Titles.DIFEL_PAGE_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementPageCucumber {

    public DifferentElementPageCucumber() {
        page(this);
    }

    @FindBy(css = ".label-checkbox > input")
    private List<SelenideElement> checkBoxes;

    @FindBy(css = ".label-radio")
    private List<SelenideElement> radioButtonTitles;

    @FindBy(css = "option")
    private List<SelenideElement> dropDownItems;

    @FindBy(css = ".label-radio > input")
    private List<SelenideElement> radioButtons;

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
    @When("I (?:un|)select checkBoxes")
    public void selectCheckBoxes(Map<Integer, String> var) {
        for (Map.Entry pair : var.entrySet()) {
            selectCheckBox((Integer) pair.getKey());
        }
    }

    @Step
    private void selectCheckBox(int count) {
        assertTrue(checkBoxes.size() > count);
        int i = 0;
        for (SelenideElement item : checkBoxes) {
            if (i == count) {
                item.click();
            }
            ++i;
        }
    }

    @Step
    @When("I select radio (.+)")
    public void selectRadioButton(String name) {
        int i = 0;
        for (SelenideElement title : radioButtonTitles) {
            if (title.getText().equalsIgnoreCase(name)) {
                iterateButtons(i, radioButtons);
            }
            ++i;
        }
    }

    @Step
    @When("I select dropdown (.+)")
    public void selectDropDownButton(String name) {
        for (SelenideElement item : dropDownItems) {
            if (item.getText().equalsIgnoreCase(name)) {
                item.click();
            }
        }
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

    //==============================checks===================================

    @Step
    @Then("The browser title is Different Elements Page")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), DIFEL_PAGE_TITLE.getTitle());
    }

    @Step
    @And("4 radiobuttons are displayed on the Different Elements Page")
    public void checkRadios() {
        for (SelenideElement radioButton : radioButtons) {
            radioButton.shouldBe(visible);
        }
    }

    @Step
    @And("4 checkboxes are displayed on the Different Elements Page")
    public void checkCheckBoxes() {
        for (SelenideElement checkBox : checkBoxes) {
            checkBox.shouldBe(visible);
        }
    }

    @Step
    @And("dropdown are displayed on the Different Elements Page")
    public void checkDropDown() {
        dropDown.shouldBe(visible);
    }

    @Step
    @And("2 buttons are displayed on the Different Elements Page")
    public void checkButtons() {
        for (SelenideElement button : buttons) {
            button.shouldBe(visible);
        }
    }

    @Step
    @And("right section are displayed on the Different Elements Page")
    public void checkRightSection() {
        lightSection.shouldBe(visible);
    }

    @Step
    @And("left section are displayed on the Different Elements Page")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    @Then("Logs are displayed and status corresponding to selected checkboxes")
    public void checkCheckBoxesLogs(Map<Integer, String> var) {
        var = var.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        Iterator<SelenideElement> logBox = logs.iterator();
        for (Map.Entry pair : var.entrySet()) {
            if (logBox.hasNext()) {
                iterateCheckBoxes((Integer) pair.getKey(), (String) pair.getValue(), logBox.next().getText());
            }
        }
    }

    @Step
    private void iterateCheckBoxes(int count, String value, String expected) {
        int i = 0;
        for (SelenideElement item : checkBoxes) {
            if (i == count) {
                checkCheckBoxLog(value, item.is(selected), expected);
            }
            ++i;
        }
    }

    @Step
    private void checkCheckBoxLog(String value, boolean isChecked, String expected) {
        assertTrue(expected.contains(value));
        assertTrue(expected.contains(String.valueOf(isChecked)));
    }

    @Step
    @Then("Log are displayed and status corresponding to selected radio (.+)")
    public void checkRadioLog(String value) {
        checkLog(value);
    }

    @Step
    @Then("Log are displayed and status corresponding to selected dropdown (.+)")
    public void checkDropDownLog(String value) {
        checkLog(value);
    }

    private void checkLog(String value) {
        String lastLogText = logs.get(0).getText();
        assertTrue(lastLogText.contains(value));
    }
}
