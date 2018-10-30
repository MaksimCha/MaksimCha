package enums;

public enum Users {

    PITER_CHALOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String title;

    Users(String login, String password, String title){
        this.login = login;
        this.password = password;
        this.title = title;
    }
}
