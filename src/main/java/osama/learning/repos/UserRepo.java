package osama.learning.repos;

import osama.learning.model.User;

import java.util.Map;
import java.util.Optional;

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

    public Optional<User> get(String username) {
        return Optional.ofNullable(users.get(username));
    }
}
