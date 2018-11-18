package hwScenarious;

import base.MobileNativeTestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstAndroidTest extends MobileNativeTestBase {

    @Test(description = "Simplest Appium")
    /**
     * This simple test just click on button 'Add contact'
     */
    public void SimplestTest() {
        String app_package_name = "com.example.android.contactmanager:id/";

//      By add_btn = By.id(app_package_name + "addContactButton");

//      By add_btn = By.xpath("//android.widget.Button[@content-desc='Add Contact']");

        By add_btn = By.className("android.widget.Button");
        driver.findElement(add_btn).click();
    }
}
