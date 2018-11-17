package enums;

public enum Links {

    HOME_PAGE_LINK("https://epam.github.io/JDI/index.html"),
    IANA_LINK("https://iana.org"),
    APPIUM_SERVER_LINK("http://0.0.0.0:4723/wd/hub");

    private String link;

    public String getLink(){
        return link;
    }

    Links(String link){
        this.link = link;
    }
}
