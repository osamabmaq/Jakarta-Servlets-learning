package osama.learning.exceptions;

public class EntryIsNotExistedException extends RuntimeException {
    public EntryIsNotExistedException() {
    }

    public EntryIsNotExistedException(String message) {
        super(message);
    }
}
