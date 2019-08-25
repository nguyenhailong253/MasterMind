import CustomException.WrongNumberOfColoursInput;

import java.util.ArrayList;

public class UserInputValidator {

    public boolean validateInputLength(ArrayList<Colour> userInput, ArrayList<Colour> answer) {
        if (userInput.size() != answer.size()) {
            throw new WrongNumberOfColoursInput(Messages.INVALID_LENGTH);
        }
        return true;
    }
}
