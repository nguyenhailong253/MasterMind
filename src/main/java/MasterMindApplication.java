import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterMindApplication {
    // TODO: packaging your service into right hierarchies

    private MasterMindGameEngine gameEngine;
    private UserInputValidator userInputValidator;
    private UserInputConverter userInputConverter;
    private boolean playerWins;

    MasterMindApplication(MasterMindGameEngine engine, UserInputConverter converter, UserInputValidator validator) {
        gameEngine = engine;
        userInputConverter = converter;
        userInputValidator = validator;
        playerWins = false;
    }

    private boolean checkGameRule(ArrayList<Colour> input, ArrayList<Colour> answer) {
        return gameEngine.checkGameRule(input, answer);
    }

    private String getUserInput(IInputEntry entry) {
        String userInput = entry.getStringInput();
        return userInput;
    }

    private ArrayList<Colour> processUserInput(String userInput) {
        String[] splittedInput = userInputConverter.splitInputToStringArray(userInput);
        ArrayList<Colour> convertedInput = userInputConverter.convertUserInput(splittedInput);
        return convertedInput;
    }

    private boolean validateNumOfColoursInput(ArrayList<Colour> userInput, ArrayList<Colour> answer) {
        if (userInputValidator.validateInputLength(userInput, answer)) {
            return true;
        }
        return false;
    }

    private void giveHints(ArrayList<String> listOfHints) {
        for (String hint: listOfHints) {
            System.out.println(hint);
        }
    }

    public void startGame(IOutputService outputService) {
        outputService.print(Messages.WELCOME);
        outputService.print(Messages.GAME_RULES);
    }

    public void closeGame(IOutputService outputService) {
        if (playerWins) {
            outputService.print(Messages.WON);
        } else {
            outputService.print(Messages.EXCEED_MAX_ATTEMPT);
        }
        outputService.print(Messages.GAME_OVER);
    }

    public ArrayList<Colour> generateRandomColours(MasterMindColourGenerator answerGenerator, int numOfColours) {
        return answerGenerator.generateRandomColours(numOfColours);
    }

    public void runGame(ArrayList<Colour> generatedColours, IInputEntry inputEntry) {
        int attemptCount = 0;

        while (attemptCount < Constants.MAX_ATTEMPT & !playerWins) {
            String userInput = getUserInput(inputEntry);
            try {
                ArrayList<Colour> convertedInputs = processUserInput(userInput);

                if (validateNumOfColoursInput(convertedInputs, generatedColours)) {
                    playerWins = gameEngine.checkGameRule(convertedInputs, generatedColours);
                }

                if (!playerWins) {
                    giveHints(gameEngine.getHintColours());
                }
                attemptCount += 1;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    public static void main(String[] args) {
        IInputEntry consoleInputEntry = new ConsoleInputEntry();
        MasterMindColourGenerator generator = new MasterMindColourGenerator();
        MasterMindGameEngine engine = new MasterMindGameEngine();
        UserInputValidator validator = new UserInputValidator();
        UserInputConverter converter = new UserInputConverter();
        IOutputService consoleOutputService = new ConsoleOutputService();

        MasterMindApplication game = new MasterMindApplication(engine, converter, validator);
        ArrayList<Colour> answers = game.generateRandomColours(generator, Constants.ANSWER_LENGTH);

        // TODO: 2019-08-26 Print answers for testing 
        for (Colour ans: answers) {
            System.out.println(ans.toString());
        }
        game.startGame(consoleOutputService);
        game.runGame(answers, consoleInputEntry);
        game.closeGame(consoleOutputService);
    }
}
