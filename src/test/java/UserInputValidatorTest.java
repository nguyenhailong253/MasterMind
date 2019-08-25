import CustomException.WrongNumberOfColoursInput;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class UserInputValidatorTest {

    static UserInputValidator validator;
    static ArrayList<Colour> answerListWith4Colours;

    public static class ValidateInputLengthTest {

        @BeforeClass
        public static void initialise() {
            validator = new UserInputValidator();
            answerListWith4Colours = new ArrayList<>();
            for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
                answerListWith4Colours.add(Colour.BLUE);
            }
        }

        @Test
        public void shouldReturnTrue_WhenInputListAndAnswerListHaveSameLength() {
            ArrayList<Colour> inputListWith4Colours = new ArrayList<>();
            for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
                inputListWith4Colours.add(Colour.GREEN);
            }
            boolean inputHasSameLength = validator.validateInputLength(inputListWith4Colours, answerListWith4Colours);

            Assert.assertTrue(inputHasSameLength);
        }

        @Test(expected = WrongNumberOfColoursInput.class)
        public void shouldThrowExceptionWhenInputListAndAnswerListHaveDifferentLength() {
            ArrayList<Colour> inputListWith2Colours = new ArrayList<>();
            inputListWith2Colours.add(Colour.RED);
            inputListWith2Colours.add(Colour.GREEN);

            validator.validateInputLength(inputListWith2Colours, answerListWith4Colours);
        }

        @Test(expected = WrongNumberOfColoursInput.class)
        public void shouldThrowExceptionWhenListIsEmpty() {
            ArrayList<Colour> emptyList = new ArrayList<>();

            validator.validateInputLength(emptyList, answerListWith4Colours);
        }
    }

}
