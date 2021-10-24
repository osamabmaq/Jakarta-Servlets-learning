package osama.learning.exceptions;

public class EntryIsNotExistedException extends ApplicationException {
    public EntryIsNotExistedException() {
        super(400);
    }

    public EntryIsNotExistedException(String message) {
        super(message, 400);
    }
}
