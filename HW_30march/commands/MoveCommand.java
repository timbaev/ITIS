package HW_30march.commands;

import HW_30march.utils.FileManagerUtils;
import HW_30march.userInteractor.ConsoleUserPrinter;

/**
 * Created by Timbaev on 05.04.2017.
 *
 */
public class MoveCommand implements Command {

    private static MoveCommand instance;

    private MoveCommand() {

    }

    public static MoveCommand getInstance() {
        if (instance == null) {
            instance = new MoveCommand();
        }
        return instance;
    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 3) {
            ConsoleUserPrinter.printErrorCommand();
            return;
        }
        if (!FileManagerUtils.getInstance().move(parameters[1], parameters[2])) {
            System.out.println("File or directory not found");
        }
    }
}
