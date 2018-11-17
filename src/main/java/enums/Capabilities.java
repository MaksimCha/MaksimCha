package enums;

public enum Capabilities {
    DEFAULT("deviceName", "platformName", "browserName", "app"),
    ANDROID_EMULATOR("emulator-5554", "Android", "Chrome", "ContactManager.apk"),
    ANDROID_REAL("ac09961b0604", "Android", "Chrome", "ContactManager.apk");

    public String deviceName;

    public String platformName;

    public String browserName;

    public String app;

    Capabilities(String deviceName, String platformName, String browserName, String app) {
        this.deviceName = deviceName;
        this.platformName = platformName;
        this.browserName = browserName;
        this.app = app;
    }
}
