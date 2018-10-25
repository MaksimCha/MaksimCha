package enums;

public enum DropDownItems {
    RED(0, "Red"),
    GREEN(1, "Green"),
    BLUE(2, "Blue"),
    YELLOW(3, "Yellow");

    public int counter;
    public String value;

    DropDownItems(int counter, String value){
        this.counter = counter;
        this.value = value;
    }
}
