import java.util.Scanner;

public class TerminalUserInteractor implements UserInteractor {

    private Scanner scanner;

    public TerminalUserInteractor() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readCommand() throws UserInteractorReadException {
        System.out.print("Enter the command: ");
        return scanner.nextLine();
    }

    @Override
    public String readAddCommand() throws UserInteractorReadException {
        System.out.print("Enter value: ");
        return scanner.nextLine();
    }

    @Override
    public void print(String output) throws UserInteractorWriteException {
        System.out.println(">> " + output);
    }
}
