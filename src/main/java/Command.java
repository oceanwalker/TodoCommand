import java.util.Scanner;

/**
 * @author Eagle
 */
public class Command {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            String excuteResult = Todo.command(command);
            System.out.println(excuteResult);
        }
    }
}
