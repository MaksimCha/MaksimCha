package enums;

public enum CheckBoxItems {

    WATER(0, "Water"),
    EARTH(1, "Earth"),
    WIND(2, "Wind"),
    FIRE(3, "Fire");

    public int counter;
    public String value;

    CheckBoxItems(int counter, String value){
        this.counter = counter;
        this.value = value;
    }
}
