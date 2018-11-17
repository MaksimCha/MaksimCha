package hwMobile.hw1;

import base.MobileNativeTestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstAndroidTest extends MobileNativeTestBase {

    @Test
    /**
     * This simple test just click on button 'Add contact'
     */
    public void SimplestTest() {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }
}
