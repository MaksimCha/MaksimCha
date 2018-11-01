package entities;

import com.epam.commons.DataClass;
import enums.Users;

import java.util.Objects;

public class User extends DataClass {

    public String name;
    public String password;

    public User(Users user){
        this.name = user.login;
        this.password = user.password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, password);
    }
}
