package HW_30march.commands;

import HW_30march.utils.FileManagerUtils;
import HW_30march.userInteractor.ConsoleUserPrinter;

/**
 * Created by Timbaev on 05.04.2017.
 */
public class CopyCommand implements Command {

    private static CopyCommand instance;

    private CopyCommand() {

    }

    public static CopyCommand getInstance() {
        if (instance == null) {
            instance = new CopyCommand();
        }
        return instance;
    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 3) {
            ConsoleUserPrinter.printErrorCommand();
            return;
        }
        if (!FileManagerUtils.getInstance().copy(parameters[1], parameters[2])) {
            System.out.println("File or directory not found");
        }
    }
}
