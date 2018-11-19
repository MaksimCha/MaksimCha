package JDISite.pages;

import JDISite.sections.MetalColorSubmitForm;
import JDISite.sections.Result;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import entities.MetalColorsPageData;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalColorPage extends WebPage {

    public MetalColorSubmitForm metalColorSubmitForm;

    public Result result;

    @Step
    public void checkResult(MetalColorsPageData dataSet){
        result.checkResult(dataSet);
    }

    @Step
    public void fillForm(MetalColorsPageData dataSet) {
        metalColorSubmitForm.fillForm(dataSet);
    }

    @Step
    public void submitButtonClick() {
        metalColorSubmitForm.submitButton.click();
    }
}
