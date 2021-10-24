package osama.learning.model;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private final String name;
    private final char[] password;

    public User(String name, char[] password) {
        if (name == null && password == null)
            throw new NullPointerException();
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && Arrays.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }
}