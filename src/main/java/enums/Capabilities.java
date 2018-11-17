package enums;

public enum Capabilities {
    DEFAULT_WEB("deviceName", "platformName", "browserName"),
    DEFAULT_NATIVE("deviceName", "platformName", "browserName", "app"),
    ANDROID_WEB_EMULATOR("emulator-5554", "Android", "Chrome"),
    ANDROID_NATIVE_EMULATOR("emulator-5554", "Android", "Chrome", "ContactManager.apk"),
    ANDROID_WEB_REAL("ac09961b0604", "Android", "Chrome"),
    ANDROID_NATIVE_REAL("ac09961b0604", "Android", "Chrome", "ContactManager.apk");

    public String deviceName;

    public String platformName;

    public String browserName;

    public String app;

    Capabilities(String deviceName, String platformName, String browserName) {
        this.deviceName = deviceName;
        this.platformName = platformName;
        this.browserName = browserName;
    }

    Capabilities(String deviceName, String platformName, String browserName, String app) {
        this.deviceName = deviceName;
        this.platformName = platformName;
        this.browserName = browserName;
        this.app = app;
    }
}
