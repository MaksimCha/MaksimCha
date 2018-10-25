package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.DataTable;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
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

    private void selectCheckBox(Integer count, String value){
        CheckBoxes.shouldBe(sizeGreaterThan(count));
        int i = 0;
        for (SelenideElement item : CheckBoxes) {
            if (i == count) {
                item.click();
                checkCheckBoxesLog(value, item.is(selected));
            }
            ++i;
        }
    }

    @Step
    @When("I select checkBoxes")
    public void selectCheckBoxes(Map<Integer, String> variables) {
        for (Object o : variables.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            selectCheckBox((Integer) pair.getKey(), (String) pair.getValue());
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
                checkLog(value);
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
    @And("4 checkboxes are displayed on the Different Elements Page")
    public void checkCheckBoxes() {
        for (SelenideElement RadioButton : RadioButtons) {
            RadioButton.shouldBe(visible);
        }
    }

    @Step
    @And("4 radiobuttons are displayed on the Different Elements Page")
    public void checkRadioButtons() {
        for (SelenideElement CheckBox : CheckBoxes) {
            CheckBox.shouldBe(visible);
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
    private void checkCheckBoxesLog(String value, boolean checked) {
        String lastLogText = Logs.first().getText();
        assertTrue(lastLogText.contains(value));
        assertTrue(lastLogText.contains(String.valueOf(checked)));
    }

    @Step
    public void checkLog(String value) {
        String lastLogText = Logs.first().getText();
        assertTrue(lastLogText.contains(value));
    }
}
