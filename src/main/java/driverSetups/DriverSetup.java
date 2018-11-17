package driverSetups;

import enums.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static enums.Capabilities.DEFAULT;
import static enums.Links.APPIUM_SERVER_LINK;

public class DriverSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidNative(Capabilities device) throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        //capabilities.setCapability("device","Android"); // mandatory???????
        capabilities.setCapability(DEFAULT.deviceName, device.deviceName);
        capabilities.setCapability(DEFAULT.platformName, device.platformName);

        // path to app
        // Copy the application (.apk), which will become AUT, to the specified location,
// e.g. "resources" folder of the project
        File appDir = new File("src\\main\\resources");
        File app = new File(appDir, device.app);

        //other caps
        capabilities.setCapability(DEFAULT.app, app.getAbsolutePath());

// Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL(APPIUM_SERVER_LINK.getLink()), capabilities);
    }

    protected void prepareAndroidWeb(Capabilities device) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability(DEFAULT.deviceName, device.deviceName);
        capabilities.setCapability(DEFAULT.platformName, device.platformName);

        // specific web capabilities
        capabilities.setCapability(DEFAULT.browserName, device.browserName);

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL(APPIUM_SERVER_LINK.getLink()),
                capabilities);

    }
}
