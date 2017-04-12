package HW_30march.commands;

import HW_30march.utils.exceptions.FileManagerException;
import HW_30march.utils.FileManagerUtils;
import HW_30march.userInteractor.ConsoleUserPrinter;

/**
 * Created by Timbaev on 30.03.2017.
 */
public class ReadFileCommand implements Command {

    private static ReadFileCommand instance;
    private static FileManagerUtils fileManagerUtils;

    public static ReadFileCommand getInstance() {
        if (instance == null) {
            instance = new ReadFileCommand();
        }
        fileManagerUtils = FileManagerUtils.getInstance();
        return instance;
    }

    private ReadFileCommand() {
    }

    @Override
    public void execute(String[] parameters) {
        try {
            if (parameters.length == 1) {
                fileManagerUtils.getFiles(false, false);
            } else {
                switch (parameters[1]) {
                    case "-a":
                        fileManagerUtils.getFiles(true, false);
                        break;
                    case "-l":
                        fileManagerUtils.getFiles(false, true);
                        break;
                    case "-la":
                        fileManagerUtils.getFiles(true, true);
                        break;
                    default:
                        ConsoleUserPrinter.printErrorCommand();
                        break;
                }
            }
        } catch (FileManagerException e) {
            System.out.println(e.getMessage());
        }
    }
}
