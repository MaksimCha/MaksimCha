package enums;

public enum Users {

    PITER_CHALOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String name;
    public String password;
    public String title;

    Users(String login, String password, String title){
        this.name = login;
        this.password = password;
        this.title = title;
    }
}
