package enums;

public enum RadioButtonItems {

    GOLD(0, "Gold"),
    SILVER(1, "Silver"),
    BRONZE(2, "Bronze"),
    SELEN(3, "Selen");

    public int counter;
    public String value;

    RadioButtonItems(int counter, String value){
        this.counter = counter;
        this.value = value;
    }
}
