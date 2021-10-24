package osama.learning.exceptions;

public abstract class ApplicationException extends RuntimeException{
    protected final int statusCode;

    public ApplicationException(int statusCode) {
        this.statusCode = statusCode;
    }

    public ApplicationException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
