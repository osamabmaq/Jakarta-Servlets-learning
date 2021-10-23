package osama.learning.exceptions;

public class EntryAlreadyExistedException extends RuntimeException {
    public EntryAlreadyExistedException() {
    }

    public EntryAlreadyExistedException(String message) {
        super(message);
    }
}
