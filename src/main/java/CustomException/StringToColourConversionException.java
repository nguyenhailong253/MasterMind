package CustomException;

public class StringToColourConversionException extends RuntimeException {

    private String customMessage;
    private Exception innerException;

    public StringToColourConversionException(String message, Exception exception) {
        super(message);
        customMessage = message;
        innerException = exception;
    }

    public String getCustomMessage() {
        return this.customMessage;
    }

    public Exception getInnerException() {
        return this.innerException;
    }
}
