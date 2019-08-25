import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class MasterMindGameEngineTest {

    static ArrayList<Colour> expectedAnswerList;
    static MasterMindGameEngine gameEngine;

    /* INTEGRATION TEST */
    public static class CheckGameRuleTest {

        @BeforeClass
        public static void initialise() {
            gameEngine = new MasterMindGameEngine();

            expectedAnswerList = new ArrayList<>();
            expectedAnswerList.add(Colour.RED);
            expectedAnswerList.add(Colour.RED);
            expectedAnswerList.add(Colour.GREEN);
            expectedAnswerList.add(Colour.YELLOW);
        }

        @Test
        public void shouldReturnTrue_WhenGivenCorrectColourList() {
            ArrayList<Colour> correctInputList = new ArrayList<>();
            correctInputList.add(Colour.RED);
            correctInputList.add(Colour.RED);
            correctInputList.add(Colour.GREEN);
            correctInputList.add(Colour.YELLOW);

            boolean inputMatchesAnswer = gameEngine.checkGameRule(correctInputList, expectedAnswerList);

            Assert.assertTrue(inputMatchesAnswer);
        }

        @Test
        public void shouldReturnFalse_WhenGivenListWith2WrongColour() {
            ArrayList<Colour> listWith2WrongColours = new ArrayList<>();
            listWith2WrongColours.add(Colour.RED);
            listWith2WrongColours.add(Colour.RED);
            listWith2WrongColours.add(Colour.PURPLE);
            listWith2WrongColours.add(Colour.ORANGE);

            boolean inputMatchesAnswer = gameEngine.checkGameRule(listWith2WrongColours, expectedAnswerList);

            Assert.assertFalse(inputMatchesAnswer);
        }
    }
}
