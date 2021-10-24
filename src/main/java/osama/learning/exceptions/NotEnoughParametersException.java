package osama.learning.exceptions;

public class NotEnoughParametersException extends ApplicationException {
    public NotEnoughParametersException() {
        super(400);
    }

    public NotEnoughParametersException(String message) {
        super(message, 400);
    }
}
