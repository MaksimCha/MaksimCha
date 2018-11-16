package JDISite;

import JDISite.pages.HomePage;
import JDISite.pages.MetalColorPage;
import JDISite.sections.LoginForm;
import JDISite.sections.MetalColorSubmitForm;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.FormData;
import entities.User;
import enums.Users;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertEquals;

@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {
    public static HomePage homePage;

    public static MetalColorPage metalColorPage;

    public static LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    public static MetalColorSubmitForm metalColorSubmitForm;

    @FindBy(css = ".info-panel-body-result")
    public static TextArea result;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User(Users.PITER_CHALOVSKII));
    }

    @Step
    public static void fillForm(FormData dataSet) {
        metalColorSubmitForm.fillForm(dataSet);
    }

    @Step
    public static void submitButtonClick() {
        metalColorSubmitForm.submitButton.click();
    }

    @Step
    public static void checkResult(FormData dataSet) {
        int sumOddsEven = 0;
        for (String sum : dataSet.summary) {
            sumOddsEven += Integer.parseInt(sum);
        }

        String elements = String.join(", ", dataSet.elements);

        String vegetables = String.join(", ", dataSet.vegetables);

        String expected =
                "Summary: " + sumOddsEven +
                        "\nElements: " + elements +
                        "\nColor: " + dataSet.color +
                        "\nMetal: " + dataSet.metals +
                        "\nVegetables: " + vegetables;

        assertEquals(result.getText(), expected);
    }

}
