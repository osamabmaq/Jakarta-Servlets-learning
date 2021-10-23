package osama.learning.model;

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

    public boolean passwordEquals(char[] password) {
        if (password == null || password.length != this.password.length)
            return false;
        for (int i = 0; i < password.length; i++)
            if (password[i] != this.password[i])
                return false;
        return true;
    }

    public boolean passwordEquals(User other) {
        return passwordEquals(other.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}