package pageObjects;

import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Lists;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

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

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> checkBoxTitles;

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
    public void selectCheckBoxes(List<String> items) {
        for (String name : items) {
            Iterator<SelenideElement> iterator = checkBoxes.iterator();
            for (SelenideElement title : checkBoxTitles) {
                SelenideElement checkBox = iterator.next();
                if (title.getText().equalsIgnoreCase(name)) {
                    checkBox.click();
                }
            }
        }
    }

    @Step
    @When("I select radio (.+)")
    public void selectRadioButton(String name) {
        int i = 0;
        for (SelenideElement title : radioButtonTitles) {
            if (title.getText().equalsIgnoreCase(name)) iterateButtons(i, radioButtons);
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

    private void iterateCheckBoxes(String value, String expected, String checked) {
        for (SelenideElement item : checkBoxTitles) {
            if (item.getText().equalsIgnoreCase(value)) checkCheckBoxLog(value, checked, expected);
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
        for (SelenideElement radioButton : radioButtons) radioButton.shouldBe(visible);
    }

    @Step
    @And("4 checkboxes are displayed on the Different Elements Page")
    public void checkCheckBoxes() {
        for (SelenideElement checkBox : checkBoxes) checkBox.shouldBe(visible);
    }

    @Step
    @And("dropdown are displayed on the Different Elements Page")
    public void checkDropDown() {
        dropDown.shouldBe(visible);
    }

    @Step
    @And("2 buttons are displayed on the Different Elements Page")
    public void checkButtons() {
        for (SelenideElement button : buttons) button.shouldBe(visible);
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
    @Then("Logs are displayed and status of selected checkboxes is (.+)")
    public void checkCheckBoxesLogs(String checked, List<String> items) {
        items = Lists.reverse(items);
        Iterator<SelenideElement> logBox = logs.iterator();
        for (String title : items) {
            if (logBox.hasNext()) {
                iterateCheckBoxes(title, logBox.next().getText(), checked);
            }
        }
    }

    private void checkCheckBoxLog(String value, String checked, String expected) {
        assertTrue(expected.contains(value));
        assertTrue(expected.contains(checked));
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
