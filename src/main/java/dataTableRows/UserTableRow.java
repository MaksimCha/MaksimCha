package dataTableRows;

public class UserTableRow {
    private Integer number;
    private String user;
    private String description ;

    public UserTableRow(Integer number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }
}