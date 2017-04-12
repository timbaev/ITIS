package HW_30march;

import HW_30march.userInteractor.AutocompleteConsole;
import HW_30march.userInteractor.Console;
import HW_30march.userInteractor.ConsoleUserInteractor;
import HW_30march.userInteractor.ConsoleUserPrinter;

/**
 * Created by Timbaev on 30.03.2017.
 * Main app class
 */
public class App {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Console console;
        boolean autocompleteMode = false;
        if (autocompleteMode) {
            console = AutocompleteConsole.getInstance();
        } else {
            console = new ConsoleUserInteractor();
        }
        do {
            ConsoleUserPrinter.enterCommand();
        } while (console.getCommand());
        System.exit(0);
    }
}
