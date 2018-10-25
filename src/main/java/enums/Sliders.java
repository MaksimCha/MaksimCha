package enums;

public enum Sliders {

    SLIDER(true, false);

    public boolean leftSide;
    public boolean rightSide;

    Sliders(boolean leftSide, boolean rightside){
        this.leftSide = leftSide;
        this.rightSide = rightside;
    }
}
