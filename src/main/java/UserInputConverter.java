import CustomException.EmptyStringException;
import CustomException.StringToColourConversionException;

import java.util.ArrayList;

public class UserInputConverter {

    public String[] splitInputToStringArray(String input) {
        if (input.length() == 0) {
            throw new EmptyStringException(Messages.EMPTY_INPUT);
        }
        input = input.replaceAll("[^A-Z\\s]", "");
        String[] result = input.trim().split("\\s+");
        return result;
    }

    public ArrayList<Colour> convertUserInput(String[] inputs) {
        try {
            ArrayList<Colour> result = new ArrayList<>();

            for (String colour : inputs) {
                result.add(Colour.valueOf(colour));
            }
            return result;

        } catch (Exception e) {
            throw new StringToColourConversionException(Messages.INVALID_COLOURS, e);
        }
    }
}
