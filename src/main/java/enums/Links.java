package enums;

public enum Links {

    HOME_PAGE_LINK("https://epam.github.io/JDI/index.html");

    private String link;

    public String getLink(){
        return link;
    }

    Links(String link){
        this.link = link;
    }
}
