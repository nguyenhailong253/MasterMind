package CustomException;

public class WrongNumberOfColoursInput extends RuntimeException {

    private String customMessage;

    public WrongNumberOfColoursInput(String message) {
        super(message);
        customMessage = message;
    }

    public String getCustomMessage() {
        return this.customMessage;
    }
}
