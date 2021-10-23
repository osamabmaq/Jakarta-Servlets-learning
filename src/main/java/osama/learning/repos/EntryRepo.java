package osama.learning.repos;

import osama.learning.exceptions.EntryAlreadyExistedException;
import osama.learning.exceptions.EntryIsNotExistedException;
import osama.learning.model.Entry;

import java.util.*;

public enum EntryRepo {
    instance;

    private final Map<String, Entry> entries = new HashMap<>();

    public void add(Entry entry) {
        if (isExisted(entry))
            throw new EntryAlreadyExistedException();
        entries.put(entry.getKey(), entry);
    }

    public Entry get(String key) {
        return Optional.ofNullable(entries.get(key))
                .orElseThrow(EntryIsNotExistedException::new);
    }

    public List<Entry> getAll() {
        return new ArrayList<>(entries.values());
    }

    public void update(Entry entry) {
        if (!isExisted(entry))
            throw new EntryIsNotExistedException();
        entries.put(entry.getKey(), entry);
    }

    public void delete(String key) {
        Optional.ofNullable(entries.remove(key))
                .orElseThrow(EntryIsNotExistedException::new);
    }

    public boolean isExisted(String key) {
        return entries.containsKey(key);
    }

    public boolean isExisted(Entry entry) {
        return isExisted(entry.getKey());
    }
}
