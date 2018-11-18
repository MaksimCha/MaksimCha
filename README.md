# Third Homework:

Use webTests.xml or nativeTests.xml to run web or native tests respectively.

1.
> Add support of appPackage and appActivity parameters for Android devices (reading from a .properties file and then setting in the DesiredCapabilities). Locally installed Appium DT has no need in these parameters, but for Appium server of Minsk Mobile Farm it’s mandatory.

Support of appPackage and appActivity parameters was added to "nativetests.properties" and "Driver.java" files

    appPackage=com.example.android.contactmanager
    appActivity=.ContactManager

    APP_PACKAGE = getProperty("appPackage");
    APP_ACTIVITY = getProperty("appActivity");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);

2. 
> Change settings to run web test on a certain iOS device on Mobile Test Farm. Run test with your changes. Did test pass?

Settings changed in "webtests.properties" and "Driver.java"

    platform=iOS
    udid=25ad632db73b1de523be6565f395cae349b4dd13

    UDID = getProperty("udid");
    capabilities.setCapability(MobileCapabilityType.UDID, UDID);

Test passed

3. 
> Change settings to run native test on a certain/random Android device on Mobile Test Farm. Run test with your changes. Did test pass?

Settings changed in "nativetests.properties" and "Driver.java"

    platform=Android
    deviceName=LGE Nexus 5

    DEVICE_NAME = getProperty("deviceName");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);

Test passed

4.
> What’s wrong with our code? How to fix/improve it? Implement your suggestions.

- Can use Page Object pattern for more clear readable code
- Using xml-file instead of .properties for cross-platform using
- Also can using special annotations like @AndroidFindBy and @iOSFindBy in addition to standard @FindBy to make code cross-platform

