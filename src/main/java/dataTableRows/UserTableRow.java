package dataTableRows;

import java.util.Map;

public class UserTableRow {
    private Integer number;
    private String user;
    private String description ;

    public Integer getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static UserTableRow createRow(Map<String, String> entry) {
        UserTableRow userRow = new UserTableRow();
        userRow.setNumber(Integer.parseInt(entry.get("number")));
        userRow.setUser(entry.get("user"));
        userRow.setDescription(entry.get("description"));
        return userRow;
    }
}