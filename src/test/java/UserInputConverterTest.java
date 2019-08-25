import CustomException.EmptyStringException;
import CustomException.StringToColourConversionException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class UserInputConverterTest {

    static UserInputConverter converter;
    static String[] expectedStringArrayWith4Colours;
    static ArrayList<Colour> expectedListWith4Reds;

    public static class SplitInputToStringArrayTest {

        @BeforeClass
        public static void initialise() {
            converter = new UserInputConverter();
            expectedStringArrayWith4Colours = new String[] {"RED", "BLUE", "GREEN", "YELLOW"};
        }

        @Test
        public void shouldReturnStringArray_WhenSplitStringInputByWhiteSpaceDelimiter() {
            String inputWithWhiteSpaceDelimiter = new String("RED BLUE GREEN YELLOW");

            String[] actualArray = converter.splitInputToStringArray(inputWithWhiteSpaceDelimiter);

            Assert.assertArrayEquals(expectedStringArrayWith4Colours, actualArray);
        }

        @Test
        public void shouldReturnStringArray_WhenGivenStringWithMultipleDelimiters() {
            String inputWithMultipleDelimters = new String("RED? BLUE.; GREEN[] ][YELLOW");

            String[] actualArray = converter.splitInputToStringArray(inputWithMultipleDelimters);

            Assert.assertArrayEquals(expectedStringArrayWith4Colours, actualArray);
        }

        @Test
        public void shouldIgnoreTrailingSpaces_WhenSplittingStringInput() {
            String inputWithTrailingSpaces = new String("  RED, BLUE, GREEN, YELLOW  ");

            String[] actualArray = converter.splitInputToStringArray(inputWithTrailingSpaces);

            Assert.assertArrayEquals(expectedStringArrayWith4Colours, actualArray);
        }

        @Test
        public void shouldIgnoreMultipleSpacesBetweenColours_WhenSplittingString() {
            String inputWithMultipleSpaces = new String("RED      BLUE       GREEN      YELLOW  ");

            String[] actualArray = converter.splitInputToStringArray(inputWithMultipleSpaces);

            Assert.assertArrayEquals(expectedStringArrayWith4Colours, actualArray);
        }

        @Test(expected = EmptyStringException.class)
        public void shouldThrowException_WhenStringInputIsEmpty() {
            String emptyString = new String();
            converter.splitInputToStringArray(emptyString);
        }
    }

    public static class ConvertUserInputTest {

        @BeforeClass
        public static void initialise() {
            converter = new UserInputConverter();

            expectedListWith4Reds = new ArrayList<>();
            for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
                expectedListWith4Reds.add(Colour.RED);
            }
        }

        @Test
        public void shouldReturnColourList_WhenReceiveStringArrayOfValidColours() {
            String[] arrayOfValidColours = new String[]{"RED", "RED", "RED", "RED"};

            ArrayList<Colour> actualList = converter.convertUserInput(arrayOfValidColours);

            Assert.assertEquals(expectedListWith4Reds, actualList);
        }

        @Test(expected = StringToColourConversionException.class)
        public void shouldThrowException_WhenReceiveStringWith1InvalidColour() {
            String[] inputWith1InvalidColour = new String[]{"RED", "MONDAY", "GREEN", "YELLOW"};
            converter.convertUserInput(inputWith1InvalidColour);
        }
    }

}
