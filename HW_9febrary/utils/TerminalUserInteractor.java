package CW_9Febrary.utils;

import java.util.Scanner;

public class TerminalUserInteractor implements UserInteractor {

    private Scanner scanner;

    public TerminalUserInteractor() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readCommand() throws UserInteractorReadException {
        System.out.print("Enter the command: ");
        String value = scanner.nextLine();
        if (value.equals("")) {
            throw new UserInteractorReadException("Error..you can not write empty command");
        }
        return value;
    }

    @Override
    public String readAddCommand() throws UserInteractorReadException {
        System.out.print("Enter value: ");
        String value = scanner.nextLine();
        if (value.equals("")) {
            throw new UserInteractorReadException("Error..you can not write empty value");
        }
        return value;
    }

    @Override
    public void print(String output) throws UserInteractorWriteException {
        System.out.println(">> " + output);
    }

    @Override
    public boolean pickIputMethod() throws UserInteractorReadException {
        System.out.print("Do you want turn on a voice input? (yes/no): ");
        String answer = scanner.nextLine();
        if (answer.equals("yes")) return true;
        if (answer.equals("no")) return false;
        throw new UserInteractorReadException("Error..you can not write empty answer");
    }
}
