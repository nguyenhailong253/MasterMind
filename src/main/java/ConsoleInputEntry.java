import java.util.Scanner;

public class ConsoleInputEntry implements IInputEntry {

    @Override
    public String getStringInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your answer: ");
        String input = scanner.nextLine();

        return input;
    }
}
