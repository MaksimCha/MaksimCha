package hwScenarious;

import base.RealDeviceNativeTestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RealDeviceAndroidTest extends RealDeviceNativeTestBase {

    @Test(description = "Simplest Appium")
    /**
     * This simple test just click on button 'Add contact'
     */
    public void SimplestTest() {
        By add_btn = By.xpath("//android.widget.Button[@content-desc=\"Add Contact\"]");
        driver.findElement(add_btn).click();
    }
}
