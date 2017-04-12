package HW_30march.userInteractor;

import HW_30march.commands.Switch;

import java.util.Scanner;

/**
 * Created by Timbaev on 30.03.2017.
 *
 */
public class ConsoleUserInteractor implements Console {

    private Scanner scanner;

    public ConsoleUserInteractor() {
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean getCommand() {
        String command = scanner.nextLine();
        if (command.equals("Exit")) return false;
        Switch.getInstance().executeCommand(command);
        return true;
    }

}
