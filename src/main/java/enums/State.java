package enums;

public enum State {
    CHECKED(true),
    UNCHECKED(false);

    public boolean isChecked;

    State(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
