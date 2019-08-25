package CustomException;

public class EmptyStringException extends RuntimeException {
    private String customMessage;

    public EmptyStringException(String message) {
        super(message);
        customMessage = message;
    }

    public String getCustomMessage() {
        return this.customMessage;
    }
}
