import org.junit.BeforeClass;
import org.junit.Test;

public class MasterMindApplicationTest {

    static MasterMindApplication application;
    static MasterMindGameEngine gameEngine;
    static MasterMindColourGenerator generator;
    static UserInputConverter converter;
    static UserInputValidator validator;
    static IInputEntry inputEntry;
    static IOutputService outputService;

    public static class RunGameTest {

        @BeforeClass
        public static void initialise() {
            gameEngine = new MasterMindGameEngine();
            converter = new UserInputConverter();
            validator = new UserInputValidator();

            application = new MasterMindApplication(gameEngine, converter, validator);

            generator = new MasterMindColourGenerator();
            inputEntry = new ConsoleInputEntry();
            outputService = new ConsoleOutputService();
        }

        @Test
        public void shouldRun60Times_WhenGiven60IncorrectSetOfInputColours() {

        }

        @Test
        public void shouldRun1Time_WhenGiven1CorrectSetOfInputColours() {

        }
    }
}
