package enums;

public enum Condition {
    CHECKED(true),
    UNCHECKED(false);

    public boolean isChecked;

    Condition(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
