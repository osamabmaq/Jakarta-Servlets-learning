package osama.learning.repos;

import osama.learning.model.User;

import java.util.Map;

import static java.util.Map.entry;

public enum UserRepo {
    instance;

    private final Map<String, User> users = Map.ofEntries(
            entry("osama", new User("osama", "1234".toCharArray())),
            entry("heba", new User("heba", "4321".toCharArray())),
            entry("mohd", new User("mohd", "one_two".toCharArray()))
    );

    public boolean exists(String username) {
        return users.containsKey(username);
    }

    public boolean exists(User user) {
        return user.equals(get(user.getName()));
    }

    public User get(String username) {
        return users.get(username);
    }
}
