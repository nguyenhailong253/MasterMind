import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MasterMindColourGeneratorTest {

    static MasterMindColourGenerator colourGenerator;

    public static class GenerateAnswerColoursTest {

        @BeforeClass
        public static void initialise() {
            colourGenerator = new MasterMindColourGenerator();
        }

        @Test
        public void shouldReturnListOf4Colours() {
            ArrayList<Colour> listOfGeneratedColours = colourGenerator.generateRandomColours(4);

            int expectedNumberOfColours = 4;

            Assert.assertEquals(expectedNumberOfColours, listOfGeneratedColours.size());
        }

        @Test
        public void shouldReturnListOfValidColours() {
            ArrayList<Colour> listOfGeneratedColours = colourGenerator.generateRandomColours(Constants.ANSWER_LENGTH);

            listOfGeneratedColours.forEach(colour -> Assert.assertTrue(Arrays.asList(Colour.values()).contains(colour)));
        }
    }


}
