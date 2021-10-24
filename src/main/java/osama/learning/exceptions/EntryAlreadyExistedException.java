package osama.learning.exceptions;

public class EntryAlreadyExistedException extends ApplicationException {
    public EntryAlreadyExistedException() {
        super(400);
    }

    public EntryAlreadyExistedException(String message) {
        super(message, 400);
    }
}
