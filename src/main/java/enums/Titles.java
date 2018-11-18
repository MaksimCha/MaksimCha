package enums;

public enum Titles {

    FIRST_HEADER_ITEM("HOME"),
    SECOND_HEADER_ITEM("CONTACT FORM"),
    THIRD_HEADER_ITEM("SERVICE"),
    FOURTH_HEADER_ITEM("METALS & COLORS"),

    FIRST_IMAGE_TITLE(
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM project"),
    SECOND_IMAGE_TITLE(
            "To be flexible and\n" +
                    "customizable"),
    THIRD_IMAGE_TITLE("To be multiplatform"),
    FOURTH_IMAGE_TITLE(
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…"),

    MAIN_HEADER_TITLE("EPAM FRAMEWORK WISHES…"),
    MAIN_HEADER_TEXT(
            "LOREM IPSUM DOLOR SIT AMET, " +
                    "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                    "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
                    "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT " +
                    "DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM " +
                    "DOLORE EU FUGIAT NULLA PARIATUR."),

    HOME_PAGE_TITLE("Home Page"),

    SUBHEADER_LINK("https://github.com/epam/JDI"),

    DIFEL_PAGE_TITLE("Different Elements"),
    DATES_PAGE_TITLE("Dates"),

    USER_TABLE_PAGE_TITLE("User Table"),

    IANA_TITLE("Internet Assigned Numbers Authority");

    private String title;

    Titles(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
