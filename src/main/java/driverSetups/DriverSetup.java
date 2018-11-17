package driverSetups;

import enums.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static enums.Capabilities.DEFAULT_NATIVE;
import static enums.Capabilities.DEFAULT_WEB;

public class DriverSetup {
    protected AndroidDriver driver;

    public void prepareAndroidNative(Capabilities device) throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        //capabilities.setCapability("device","Android"); // mandatory???????
        capabilities.setCapability(DEFAULT_NATIVE.deviceName,device.deviceName);
        capabilities.setCapability(DEFAULT_NATIVE.platformName,device.platformName);

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

    protected void prepareAndroidWeb(Capabilities device) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability(DEFAULT_WEB.deviceName,device.deviceName);
        capabilities.setCapability(DEFAULT_WEB.platformName,device.platformName);

        // specific web capabilities
        capabilities.setCapability(DEFAULT_WEB.browserName, device.browserName);

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),
                capabilities);

    }
}
