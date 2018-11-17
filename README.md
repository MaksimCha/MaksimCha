# MaksimCha

First Homework:
>Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.

Tests are located in src/test/java/hwScenarios directory

>For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?

        By add_btn = By.id(app_package_name + "addContactButton");

        By add_btn = By.xpath("//android.widget.Button[@content-desc='Add Contact']");

        By add_btn = By.className("android.widget.Button");
        
>Modify existing tests to run on a real device. What should be changed?

Connect real device to computer by USB with USB debug mode
Open terminal and type “adb devices” command
Find out its identifier and change value of capaibility “deviceName” to phone identifier

>Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?

To connect a real device to appium we need to do next actions:

Create new capabilitiies set for real device: type deviceName with the identifier of real device
Run appium session and run modified tests

>What should be improved/changed in existing test code? Why, for what?

Move driver setup to main directory because it is a service code
Don't using hardcoded absolute paths because on another devices they can be defferent and it’s hard to find those values
Don't using System.out for logging – it is not good for code readability
Don't using Thread.sleep() - it reduces performance
Change structure so that Native and Web tests were in the different classes
