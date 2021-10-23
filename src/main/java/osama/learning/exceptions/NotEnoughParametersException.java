package osama.learning.exceptions;

public class NotEnoughParametersException extends RuntimeException {
    public NotEnoughParametersException() {
    }

    public NotEnoughParametersException(String message) {
        super(message);
    }
}
