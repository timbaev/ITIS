package HW_30march.commands;

import HW_30march.utils.FileManagerUtils;
import HW_30march.userInteractor.ConsoleUserPrinter;

/**
 * Created by Timbaev on 05.04.2017.
 */
public class RemoveCommand implements Command {

    private static RemoveCommand instance;

    private RemoveCommand() {

    }

    public static RemoveCommand getInstance() {
        if (instance == null) {
            instance = new RemoveCommand();
        }
        return instance;
    }


    @Override
    public void execute(String[] parameters) {
        if (parameters.length < 2 && parameters.length > 3) {
            ConsoleUserPrinter.printErrorCommand();
            return;
        }
        String file;
        String parameter = null;
        if (parameters.length == 2) {
            file = parameters[1];
        } else {
            parameter = parameters[1];
            file = parameters[2];
        }
        if (parameter != null) {
            boolean result = false;
            switch (parameter) {
                case "-r":
                    result = FileManagerUtils.getInstance().remove(file, true, false);
                    break;
                case "-f":
                    result = FileManagerUtils.getInstance().remove(file, false, true);
                    break;
                case "-rf":
                    result = FileManagerUtils.getInstance().remove(file, true, true);
                    break;
                case "-fr":
                    result = FileManagerUtils.getInstance().remove(file, true, true);
            }
            if (!result) System.out.println("File or directory not found!");
        } else {
            if (!FileManagerUtils.getInstance().remove(file, false, false)) System.out.println("File not found!");
        }
    }
}
