package HW_7march;

import HW_7march.database.Database;
import HW_7march.entitys.Track;
import HW_7march.userTerminal.InfoPrinter;
import HW_7march.userTerminal.UserTerminalManager;

/**
 * Created by Timbaev on 08.03.2017.
 * Main app manager for users
 */
public class AppManager {

    private Database database;
    private UserTerminalManager userTerminalManager;

    public AppManager() {
        init();
        listenCommand();
    }

    private void init() {
        database = Database.getInstance();
        userTerminalManager = new UserTerminalManager();
    }

    private void listenCommand() {
        while (true) {
            String command = userTerminalManager.readCommand();
            switch (command) {
                case "exit":
                    System.out.println("Ok, closing the program");
                    System.exit(0);
                    break;
                case "add":
                    Track track = userTerminalManager.addTrackCommand();
                    if (track != null) database.addTrack(track);
                    break;
                case "remove":
                    int position = userTerminalManager.removeTrackCommand();
                    if (position != -1) database.removeTrack(position);
                    break;
                case "search":
                    userTerminalManager.searchTrackCommand();
                    break;
                case "sort":
                    userTerminalManager.sortTrackCommand();
                    break;
                case "print":
                    InfoPrinter.printInfo(database.getTracks());
                    break;
                default:
                    System.out.println("Error..command not found");
                    break;
            }
        }
    }
}
