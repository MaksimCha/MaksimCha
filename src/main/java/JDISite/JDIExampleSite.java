package JDISite;

import JDISite.pages.HomePage;
import JDISite.pages.MetalColorPage;
import JDISite.sections.LoginForm;
import JDISite.sections.MetalColorSubmitForm;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.FormData;
import entities.User;
import enums.Users;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {
    public static HomePage homePage;

    public static MetalColorPage metalColorPage;

    public static LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    public static MetalColorSubmitForm metalColorSubmitForm;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User(Users.PITER_CHALOVSKII));
    }

    @Step
    public static void fillForm(FormData dataSet) {
        metalColorSubmitForm.vegetables.select("vegetables");
        for (String vegetable : dataSet.vegetables){
            metalColorSubmitForm.vegetables.select(vegetable);
        }
        metalColorSubmitForm.metals.click();
        metalColorSubmitForm.metals.select(dataSet.metals);
        for (String element : dataSet.elements) {
            metalColorSubmitForm.elementsCheckBoxes.select(element);
        }
        metalColorSubmitForm.colors.select(dataSet.color);
        metalColorSubmitForm.oddsRadioButtons.select(dataSet.summary.get(0));
        metalColorSubmitForm.evenRadioButtons.select(dataSet.summary.get(1));
    }

    @Step
    public static void submitButtonClick(){
        metalColorSubmitForm.submitButton.click();
    }

}
