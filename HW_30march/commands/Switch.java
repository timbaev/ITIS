package HW_30march.commands;

import HW_30march.userInteractor.ConsoleUserPrinter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Timbaev on 30.03.2017.
 * Switch class for commands
 */
public class Switch {

    private Map<String, Command> commands;
    private static Switch instance;

    private Switch() {
        commands = new HashMap<>();
        commands.put("ls", ReadFileCommand.getInstance());
        commands.put("cd", PickPathCommand.getInstance());
        commands.put("rm", RemoveCommand.getInstance());
        commands.put("mv", MoveCommand.getInstance());
        commands.put("cp", CopyCommand.getInstance());
    }

    public static Switch getInstance() {
        if (instance == null) {
            instance = new Switch();
        }
        return instance;
    }

    public void executeCommand(String command) {
        String[] commandParts = command.split(" ");
        Command cmd = commands.get(commandParts[0]);
        if (cmd == null) {
            ConsoleUserPrinter.printErrorCommand();
            return;
        }
        cmd.execute(commandParts);
    }
}
