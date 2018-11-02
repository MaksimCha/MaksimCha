package JDISite.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.FormData;
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
            value = @FindBy(tagName = "button")
    )
    public Dropdown metals;

    @FindBy(id = "odds-selector")
    public RadioButtons oddsRadioButtons;

    @FindBy(id = "even-selector")
    public RadioButtons evenRadioButtons;

    @FindBy(id = "elements-checklist")
    public CheckList elementsCheckBoxes;
}
