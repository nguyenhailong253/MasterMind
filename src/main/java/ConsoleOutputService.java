import java.util.List;

public class ConsoleOutputService implements IOutputService {

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    public void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));;
            System.out.print(" ");
        }
        System.out.println("");
    }
}
