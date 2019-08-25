import java.util.ArrayList;
import java.util.Collections;

public class MasterMindGameEngine {

    private ArrayList<String> hintColours;

    MasterMindGameEngine() {
        hintColours = new ArrayList<>();
    }

    public ArrayList<String> getHintColours() {
        return this.hintColours;
    }

    private String getHintColour(Colour guessColour, Colour answerColour, ArrayList<Colour> answerList) {

        if (guessColour == answerColour) {
            return Constants.BLACK;
        } else if (answerList.contains(guessColour)) {
            return Constants.WHITE;
        }
        return new String();
    }

    private ArrayList<String> processListOfHintColours(ArrayList<Colour> input, ArrayList<Colour> answer) {

        ArrayList<String> listOfHints = new ArrayList<>();

        for (int i = 0; i < answer.size(); i++) {
            String hintColour;
            Colour currentGuessColour = input.get(i);
            Colour currentAnswerColour = answer.get(i);

            hintColour = getHintColour(currentGuessColour, currentAnswerColour, answer);

            if (!hintColour.isEmpty()) {
                listOfHints.add(hintColour);
            }
        }
        return listOfHints;
    }

    private ArrayList<String> shuffleListOfHintColours(ArrayList<String> listOfHints) {
        Collections.shuffle(listOfHints);
        return listOfHints;
    }

    private boolean isGameWon(ArrayList<String> listOfHintColours) {
        int numOfBlacksInListOfHints = Collections.frequency(listOfHintColours, Constants.BLACK);
        int numOfBlacksToWin = Constants.ANSWER_LENGTH;
        return numOfBlacksInListOfHints == numOfBlacksToWin;
    }

    public boolean checkGameRule(ArrayList<Colour> input, ArrayList<Colour> answer) {
        // TODO: 2019-08-25 Do we use this.hintColours in here? 
        hintColours = processListOfHintColours(input, answer);
        hintColours = shuffleListOfHintColours(hintColours);
        boolean playerWins = isGameWon(hintColours);

        return playerWins;
    }
}
