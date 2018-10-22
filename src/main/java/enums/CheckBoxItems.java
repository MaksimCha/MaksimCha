package enums;

public enum CheckBoxItems {

    DIF_EL_ITEM_WATER(0, "Water"),
    DIF_EL_ITEM_EARTH(1, "Earth"),
    DIF_EL_ITEM_WIND(2, "Wind"),
    DIF_EL_ITEM_FIRE(3, "Fire");

    public int counter;
    public String value;

    CheckBoxItems(int counter, String value){
        this.counter = counter;
        this.value = value;
    }
}
