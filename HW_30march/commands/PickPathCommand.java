package HW_30march.commands;

import HW_30march.utils.FileManagerUtils;
import HW_30march.userInteractor.ConsoleUserPrinter;

/**
 * Created by Timbaev on 05.04.2017.
 */
public class PickPathCommand implements Command {

    private static PickPathCommand instance;

    private PickPathCommand() {

    }

    public static PickPathCommand getInstance() {
        if (instance == null) {
            instance = new PickPathCommand();
        }
        return instance;
    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 2) {
            ConsoleUserPrinter.printErrorCommand();
            return;
        }
        String path = parameters[1];
        if (!FileManagerUtils.getInstance().pickPath(path)) {
            System.out.println("Directory not found!");
        }
    }
}
