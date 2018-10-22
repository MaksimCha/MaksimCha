package enums;

public enum RadioButtonItems {

    DIF_EL_ITEM_GOLD(0, "Gold"),
    DIF_EL_ITEM_SILVER(1, "Silver"),
    DIF_EL_ITEM_BRONZE(2, "Bronze"),
    DIF_EL_ITEM_SELEN(3, "Selen");

    public int counter;
    public String value;

    RadioButtonItems(int counter, String value){
        this.counter = counter;
        this.value = value;
    }
}
