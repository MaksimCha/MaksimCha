package driverSetups;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class RealDeviceDriverSetup {
    protected AndroidDriver driver;

    public void prepareAndroidNative() throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        //capabilities.setCapability("device","Android"); // mandatory???????
        capabilities.setCapability("deviceName","Redmi Note 4");
        capabilities.setCapability("platformName","Android");

        // path to app
        // Copy the application (.apk), which will become AUT, to the specified location,
// e.g. "resources" folder of the project
        File appDir = new File("D:\\Projects\\MaksimCha\\src\\main\\resources");
        File app = new File(appDir, "ContactManager.apk");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

// Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    protected void prepareAndroidWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName","Android");

        // specific web capabilities
        capabilities.setCapability("browserName", "Chrome");

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),
                capabilities);

    }
}
