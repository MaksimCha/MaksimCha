package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.CheckBoxItems.WATER;
import static enums.CheckBoxItems.WIND;
import static enums.Titles.DIFEL_PAGE_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ServicePageSelenideCucumber {

    private ElementsCollection CheckBoxes = $$(By.cssSelector(".label-checkbox > input"));

    private ElementsCollection RadioButtons = $$(By.cssSelector(".label-radio > input"));

    private ElementsCollection DropDownItems = $$(By.cssSelector(".colors .uui-form-element > option"));

    private SelenideElement DropDown = $(By.cssSelector(".main-content-hg .colors"));

    private ElementsCollection Buttons = $$(By.cssSelector(".main-content-hg .uui-button"));

    private SelenideElement LeftSection = $(By.cssSelector(".sidebar-menu"));

    private SelenideElement RightSection = $(By.cssSelector(".right-fix-panel"));

    private ElementsCollection Logs = $$(By.cssSelector(".panel-body-list.logs > li"));

    //==============================methods==================================

    @Step
    @When("I select checkBoxes")
    public void selectCheckBoxes(Map<Integer, String> var){
        for (Map.Entry pair: var.entrySet()) {
            selectCheckBox((Integer)pair.getKey());
        }
    }

    @Step
    private void selectCheckBox(int count) {
        CheckBoxes.shouldBe(sizeGreaterThan(count));
        int i = 0;
        for (SelenideElement item : CheckBoxes) {
            if (i == count) {
                item.click();
            }
            ++i;
        }
    }

    @Step
    public void selectRadioButton(int count, String value) {
        RadioButtons.shouldBe(sizeGreaterThan(count));
        iterateButtons(count, value, RadioButtons);
    }

    @Step
    public void selectDropDownButton(int count, String value) {
        DropDownItems.shouldBe(sizeGreaterThan(count));
        iterateButtons(count, value, DropDownItems);
    }

    private void iterateButtons(int count, String value, ElementsCollection Items) {
        int i = 0;
        for (SelenideElement item : Items) {
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
        assertEquals(getWebDriver().getTitle(), DIFEL_PAGE_TITLE.title);
    }

    @Step
    public void checkDifElPageExists() {
        this.checkCheckBoxes();
        this.checkRadioButtons();
        this.checkDropDown();
        this.checkButtons();
    }

    @Step
    @And("4 checkboxes are displayed on the Different Elements Page")
    public void checkCheckBoxes() {
        for (SelenideElement RadioButton : RadioButtons) {
            RadioButton.shouldBe(visible);
        }
    }

    @Step
    @And("4 radiobuttons are displayed on the Different Elements Page")
    public void checkRadioButtons() {
        for (SelenideElement CheckBoxe : CheckBoxes) {
            CheckBoxe.shouldBe(visible);
        }
    }

    @Step
    @And("dropdown are displayed on the Different Elements Page")
    public void checkDropDown() {
        DropDown.shouldBe(visible);
    }

    @Step
    @And("2 buttons are displayed on the Different Elements Page")
    public void checkButtons() {
        for (SelenideElement Button : Buttons) {
            Button.shouldBe(visible);
        }
    }

    @Step
    @And("right section are displayed on the Different Elements Page")
    public void checkRightSection() {
        RightSection.shouldBe(visible);
    }

    @Step
    @And("left section are displayed on the Different Elements Page")
    public void checkLeftSection() {
        LeftSection.shouldBe(visible);
    }

    @Step
    public void checkCheckBoxesLogs() {
        iterateCheckBoxes(WIND.counter, WIND.value, Logs.first().getText());
        Iterator<SelenideElement> Log = Logs.iterator();
        Log.next();
        iterateCheckBoxes(WATER.counter, WATER.value, Log.next().getText());
    }

    @Step
    private void iterateCheckBoxes(int count, String value, String expected) {
        int i = 0;
        for (SelenideElement item : CheckBoxes) {
            if (i == count) {
                checkCheckBoxLog(value, item.is(selected), expected);
            }
            ++i;
        }
    }

    @Step
    private void checkCheckBoxLog(String value, boolean checked, String expected) {
        assertTrue(expected.contains(value));
        assertTrue(expected.contains(String.valueOf(checked)));
    }

    @Step
    public void checkLog(String value) {
        String lastLogText = Logs.first().getText();
        assertTrue(lastLogText.contains(value));
    }
}
