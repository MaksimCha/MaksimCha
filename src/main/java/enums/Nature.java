package enums;

public enum Nature {
    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire");

    public String value;

    Nature(String value) {
        this.value = value;
    }
}
