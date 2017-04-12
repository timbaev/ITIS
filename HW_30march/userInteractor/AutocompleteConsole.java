package HW_30march.userInteractor;

import HW_30march.commands.Switch;
import jline.console.ConsoleReader;
import jline.console.completer.StringsCompleter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timbaev on 10.04.2017.
 */
public class AutocompleteConsole implements Console {

    private ConsoleReader console;
    private static AutocompleteConsole instance;
    public static boolean isStarted = false;

    public static AutocompleteConsole getInstance() {
        if(instance == null) {
            instance = new AutocompleteConsole();
            isStarted = true;
        }
        return instance;
    }

    private AutocompleteConsole() {
        try {
            console = new ConsoleReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean getCommand() {
        try {
            String command = console.readLine();
            if (command.equals("Exit")) return false;
            Switch.getInstance().executeCommand(command);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setCompleters(File[] files) {
        List<String> filesName = new ArrayList<>();
        for (File file : files) {
            filesName.add(file.getName());
        }
        console.addCompleter(new StringsCompleter(filesName));
    }
}
