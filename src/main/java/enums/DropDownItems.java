package enums;

public enum DropDownItems {
    DIF_EL_ITEM_RED(0, "Red"),
    DIF_EL_ITEM_GREEN(1, "Green"),
    DIF_EL_ITEM_BLUE(2, "Blue"),
    DIF_EL_ITEM_YELLOW(3, "Yellow");

    public int counter;
    public String value;

    DropDownItems(int counter, String value){
        this.counter = counter;
        this.value = value;
    }
}
