package enums;

public enum Capabilities {
    DEFAULT_WEB("deviceName", "platformName", "browserName"),
    DEFAULT_NATIVE("deviceName", "platformName"),
    ANDROID_WEB_EMULATOR("emulator-5554", "Android", "Chrome"),
    ANDROID_NATIVE_EMULATOR("emulator-5554", "Android"),
    ANDROID_WEB_REAL("ac09961b0604", "Android", "Chrome"),
    ANDROID_NATIVE_REAL("ac09961b0604", "Android");

    public String deviceName;

    public String platformName;

    public String browserName;

    Capabilities(String deviceName, String platformName, String browserName) {
        this.deviceName = deviceName;
        this.platformName = platformName;
        this.browserName = browserName;
    }

    Capabilities(String deviceName, String platformName) {
        this.deviceName = deviceName;
        this.platformName = platformName;
    }
}
