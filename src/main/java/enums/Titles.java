package enums;

public enum Titles {

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

    LOGIN_TITLE("PITER CHAILOVSKII"),
    HOME_PAGE_TITLE("Home Page"),

    FIRST_HEADER_ITEM_TITLE("HOME"),
    SECOND_HEADER_ITEM_TITLE("CONTACT FORM"),
    THIRD_HEADER_ITEM_TITLE("SERVICE"),
    FOURTH_HEADER_ITEM_TITLE("METALS & COLORS"),

    SUBHEADER_LINK("https://github.com/epam/JDI"),

    FIRST_SERVICE_HEADER("SUPPORT"),
    SECOND_SERVICE_HEADER("DATES"),
    THIRD_SERVICE_HEADER("COMPLEX TABLE"),
    FOURTH_SERVICE_HEADER("SIMPLE TABLE"),
    FIFTH_SERVICE_HEADER("USER TABLE"),
    SIXTH_SERVICE_HEADER("TABLE WITH PAGES"),
    SEVENTH_SERVICE_HEADER("DIFFERENT ELEMENTS"),
    EIGHTH_SERVICE_HEADER("PERFORMANCE"),

    FIRST_SERVICE_LEFTER("Support"),
    SECOND_SERVICE_LEFTER("Dates"),
    THIRD_SERVICE_LEFTER("Complex Table"),
    FOURTH_SERVICE_LEFTER("Simple Table"),
    FIFTH_SERVICE_LEFTER("User Table"),
    SIXTH_SERVICE_LEFTER("Table with pages"),
    SEVENTH_SERVICE_LEFTER("Different elements"),
    EIGHTH_SERVICE_LEFTER("Performance"),

    DIFEL_PAGE_TITLE("Different Elements"),

    USER_TABLE_PAGE_TITLE("User Table");

    public String title;

    Titles(String title) {
        this.title = title;
    }
}
