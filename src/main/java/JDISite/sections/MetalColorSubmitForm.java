package JDISite.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.FormData;
import enums.Even;
import enums.Nature;
import enums.Odds;
import org.openqa.selenium.support.FindBy;

public class MetalColorSubmitForm extends Form<FormData> {

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    public Dropdown vegetables;

    @JDropdown(
            root = @FindBy(id = "colors"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    public Dropdown colors;

    @JDropdown(
            root = @FindBy(id = "metals"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button"),
            expand = @FindBy(css = "[id = 'metals'] .btn-default .caret")
    )
    public Dropdown metals;

    @FindBy(css = "#odds-selector p")
    public Selector<Odds> oddsRadioButtons;

    @FindBy(css = "#even-selector p")
    public RadioButtons<Even> evenRadioButtons;

    @FindBy(css = ".elements .checkbox")
    public CheckList<Nature> elementsCheckBoxes;

    @FindBy(id = "submit-button")
    public Button submitButton;

    public void fillForm(FormData dataSet) {
        vegetables.select("vegetables");
        for (String vegetable : dataSet.vegetables) {
            vegetables.select(vegetable);
        }
        colors.select(dataSet.color);
        metals.select(dataSet.metals);
        for (String element : dataSet.elements) {
            elementsCheckBoxes.select(element);
        }
        oddsRadioButtons.select(dataSet.summary.get(0));
        evenRadioButtons.select(dataSet.summary.get(1));
    }
}
