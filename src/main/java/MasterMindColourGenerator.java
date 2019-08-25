import java.util.ArrayList;
import java.util.Random;

public class MasterMindColourGenerator {

    public ArrayList<Colour> generateRandomColours(int numOfColours) {
        ArrayList<Colour> answer = new ArrayList<>();
        Random random = new Random();
        int randomIndex;

        for (int i = 0; i < numOfColours; i++) {
            // randomise index in Enum list and get corresponding colour
            randomIndex = random.nextInt(Colour.values().length);
            answer.add(Colour.values()[randomIndex]);
        }

        return answer;
    }
}
