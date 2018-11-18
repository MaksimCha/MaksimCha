package hwScenarious.nativeTests;

import driverSetups.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@Test(groups = "native")
public class NativeTests extends Driver {

    @Test(description = "Check fields and titles of Add Contact form")
    public void AddContactFormTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";

        // Click button "Add Contact"
        By add_btn = By.id(app_package_name + "addContactButton");

//      By add_btn = By.className("android.widget.Button");

//      By add_btn = By.xpath("//android.widget.Button[@content-desc='Add Contact']");

        driver().findElement(add_btn).click();

        // Check title "Target Account"
        By targetTitle = By.xpath("//android.widget.TextView[@content-desc='Target Account']");
        assertEquals(driver().findElement(targetTitle).getText(), "Target Account");

        // Check text field for "Target Account" is displayed
        By targetField = By.id(app_package_name + "accountSpinner");
        assertTrue(driver().findElement(targetField).isDisplayed());

        // Check title "Contact Name"
        By contactNameTitle = By.xpath("//android.widget.TextView[@content-desc='Contact Name']");
        assertEquals(driver().findElement(contactNameTitle).getText(), "Contact Name");

        // Check text field for "Contact Name" is displayed
        By contactNameField = By.id(app_package_name + "contactNameEditText");
        assertTrue(driver().findElement(contactNameField).isDisplayed());

        // Check title "Contact Phone"
        By contactPhoneTitle= By.xpath("//android.widget.TextView[@content-desc='Contact Phone']");
        assertEquals(driver().findElement(contactPhoneTitle).getText(), "Contact Phone");

        // Check text field for "Contact Phone" is displayed
        By contactPhoneField= By.id(app_package_name + "contactPhoneEditText");
        assertTrue(driver().findElement(contactPhoneField).isDisplayed());
    }
}
