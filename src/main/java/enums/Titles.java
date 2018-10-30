package enums;

import java.util.HashSet;
import java.util.Set;

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

    FIRST_HEADER_ITEM("HOME"),
    SECOND_HEADER_ITEM("CONTACT FORM"),
    THIRD_HEADER_ITEM("SERVICE"),
    FOURTH_HEADER_ITEM("METALS & COLORS"),

    SUBHEADER_LINK("https://github.com/epam/JDI"),

    FIRST_SERVICE_BUTTON("Support"),
    SECOND_SERVICE_BUTTON("Dates"),
    THIRD_SERVICE_BUTTON("Complex Table"),
    FOURTH_SERVICE_BUTTON("Simple Table"),
    FIFTH_SERVICE_BUTTON("User Table"),
    SIXTH_SERVICE_BUTTON("Table with pages"),
    SEVENTH_SERVICE_BUTTON("Different elements"),
    EIGHTH_SERVICE_BUTTON("Performance"),

    DIFEL_PAGE_TITLE("Different Elements"),

    USER_TABLE_PAGE_TITLE("User Table");

    private String title;

    Titles(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public static Set<String> getServiceTitleSet(){
        Set<String> services = new HashSet<>();
        services.add(FIRST_SERVICE_BUTTON.getTitle().toUpperCase());
        services.add(SECOND_SERVICE_BUTTON.getTitle().toUpperCase());
        services.add(THIRD_SERVICE_BUTTON.getTitle().toUpperCase());
        services.add(FOURTH_SERVICE_BUTTON.getTitle().toUpperCase());
        services.add(FIFTH_SERVICE_BUTTON.getTitle().toUpperCase());
        services.add(SIXTH_SERVICE_BUTTON.getTitle().toUpperCase());
        services.add(SEVENTH_SERVICE_BUTTON.getTitle().toUpperCase());
        services.add(EIGHTH_SERVICE_BUTTON.getTitle().toUpperCase());
        return services;
    }

    public static Set<String> getImageTitleSet(){
        Set<String> images = new HashSet<>();
        images.add(FIRST_HEADER_ITEM.getTitle().toUpperCase());
        images.add(SECOND_HEADER_ITEM.getTitle().toUpperCase());
        images.add(THIRD_HEADER_ITEM.getTitle().toUpperCase());
        images.add(FOURTH_HEADER_ITEM.getTitle().toUpperCase());
        return images;
    }
}
