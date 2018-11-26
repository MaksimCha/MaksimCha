package pageObjects;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Titles.USER_TABLE_PAGE_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserTablePageSelenideCucumber {

    @FindBy(css = "table select")
    private List<SelenideElement> typeDropDownItems;

    @FindBy(css = "table a")
    private List<SelenideElement> userNames;

    @FindBy(css = "table img")
    private List<SelenideElement> descriptionImages;

    @FindBy(css = ".user-descr > span")
    private List<SelenideElement> descriptionTexts;

    @FindBy(css = ".user-descr > input")
    private List<SelenideElement> checkBoxes;

    @FindBy(css = "[id = 'user-table'] td")
    private List<SelenideElement> userTable;

    @FindBy(css = "table input")
    private List<SelenideElement> statusItems;

    @FindBy(css = ".panel-body-list.logs > li")
    private List<SelenideElement> logs;

    private Integer count = 0;

    //==============================methods==================================

    public UserTablePageSelenideCucumber() {
        page(this);
    }

    @Step
    @When("I select 'vip' checkbox for \"(.+)\"")
    public void vipCheckBoxClick(String name) {
        Iterator<SelenideElement> status = statusItems.iterator();
        for (SelenideElement userName : userNames) {
            if (userName.getText().equalsIgnoreCase(name)) {
                status.next().click();
                break;
            }
            status.next();
        }
    }

    @Step
    @When("I click on dropdown in column Type for user (.+)")
    public void typeDropDownClick(String name) {
        Iterator<SelenideElement> item = typeDropDownItems.iterator();
        count = 0;
        for (SelenideElement userName : userNames) {
            if (userName.getText().equalsIgnoreCase(name)) {
                item.next().click();
                break;
            }
            item.next();
            ++count;
        }
    }

    private List<List<String>> listToTable(List<SelenideElement> selenideItems, int length) {
        List<String> list = new ArrayList<>();
        for (SelenideElement item : selenideItems) {
            list.add(item.getText());
        }
        List<List<String>> table = new ArrayList<>();
        int N = list.size();
        for (int i = 0; i < N; i += length) {
            table.add(new ArrayList<>(
                    list.subList(i, Math.min(N, i + length)))
            );
        }
        return table;
    }

    //==============================checks===================================

    @Step
    @Then("\"User Table\" page is opened")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), USER_TABLE_PAGE_TITLE.getTitle());
    }

    @Step
    @And("6 NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkNumberTypeDropDowns() {
        for (SelenideElement numberType : typeDropDownItems) {
            numberType.shouldBe(visible);
        }
    }

    @Step
    @And("6 User names are displayed on Users Table on User Table Page")
    public void checkUserNames() {
        for (SelenideElement userName : userNames) {
            userName.shouldBe(visible);
        }
    }

    @Step
    @And("6 Description images are displayed on Users Table on User Table Page")
    public void checkDescriptionImages() {
        for (SelenideElement descriptionImage : descriptionImages) {
            descriptionImage.shouldBe(visible);
        }
    }

    @Step
    @And("6 Description texts under images are displayed on Users Table on User Table Page")
    public void checkDescriptionTexts() {
        for (SelenideElement descriptionText : descriptionTexts) {
            descriptionText.shouldBe(visible);
        }
    }

    @Step
    @And("6 checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckBoxes() {
        for (SelenideElement checkBox : checkBoxes) {
            checkBox.shouldBe(visible);
        }
    }

    @Step
    @And("^User table contains following values$")
    public void checkUserTable(List<List<String>> table) {
        table.remove(0);
        Iterator<SelenideElement> element = userTable.iterator();
        for (List<String> row : table) {
            if (element.hasNext()) {
                element.next().shouldBe(text(row.get(0)));
                element.next();
                element.next().shouldBe(text(row.get(1)));
                element.next().shouldBe(text(row.get(2)));
            }
        }
    }

    @Step
    @Then("1 log row has \"(.+)\" text in log section")
    public void checkLog(String expected) {
        Iterator<SelenideElement> log = logs.iterator();
        assertTrue(log.next().getText().contains(expected));
    }

    @Step
    @Then("droplist contains values")
    public void checkDropListContent(List<String> containItems) {
        List<List<String>> typeTable = listToTable(typeDropDownItems, 3);
        assertTrue(typeTable.get(count).containsAll(containItems.subList(1, containItems.size())));
    }
}
