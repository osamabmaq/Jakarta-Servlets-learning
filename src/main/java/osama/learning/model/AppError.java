package osama.learning.model;

import osama.learning.exceptions.ApplicationException;

import javax.servlet.http.HttpServletRequest;

public class AppError {
    private final int statusCode;
    private final Class<?> exceptionType;
    private final String message;
    private final String requestUri;
    private final Throwable exception;
    private final String servletName;

    public AppError(HttpServletRequest req) {
        exceptionType = (Class<?>) req.getAttribute("javax.servlet.error.exception_type");
        message = (String) req.getAttribute("javax.servlet.error.message");
        requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");
        exception = (Throwable) req.getAttribute("javax.servlet.error.exception");
        servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
        statusCode = extractStatusCode(req, exception);
    }

    private int extractStatusCode(HttpServletRequest req, Throwable exception) {
        if (exception instanceof ApplicationException applicationException)
            return applicationException.getStatusCode();
        else
            return (int) req.getAttribute("javax.servlet.error.status_code");
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Class<?> getExceptionType() {
        return exceptionType;
    }

    public String getMessage() {
        return message;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public Throwable getException() {
        return exception;
    }

    public String getServletName() {
        return servletName;
    }

    @Override
    public String toString() {
        return "AppError{" +
                "statusCode=" + statusCode +
                ", exceptionType=" + exceptionType +
                ", message='" + message + '\'' +
                ", requestUri='" + requestUri + '\'' +
                ", exception=" + exception +
                ", servletName='" + servletName + '\'' +
                '}';
    }
}