package HW_14febrary;

import HW_14febrary.UI.ConsoleUserInteractor;
import HW_14febrary.UI.UserInteractor;
import HW_14febrary.UI.exceptions.UserInteractorInputException;
import HW_14febrary.UI.exceptions.UserInteractorReadException;
import HW_14febrary.data.MusicStorage;
import HW_14febrary.musicHandler.MP3;
import HW_14febrary.musicHandler.Player;

/**
 * Created by Timbaev on 14.02.2017.
 * Main app for Music Player
 */
public class App extends Application {

    private UserInteractor consoleInteractor;
    private MusicStorage musicStorage;
    private Player MP3player;

    private App(String[] args) {
        super(args);
    }

    public static void main(String[] args) {
        new App(args);
    }

    @Override
    public void init() {
        consoleInteractor = new ConsoleUserInteractor();
        musicStorage = new MusicStorage();
        MP3player = new MP3(musicStorage);
    }

    @Override
    public void start() {
        try {
            String command;
            while (true) {
                command = consoleInteractor.readCommand();
                switch (command) {
                    case ("exit"):
                        System.out.print("Close the program");
                        System.exit(0);
                        break;
                    case ("play"):
                        if (!MP3player.isTrackPicked()) {
                            MP3player.pickTrack(consoleInteractor.readTrackNumber());
                        }
                        MP3player.play();
                        break;
                    case ("pause"):
                        MP3player.pause();
                        break;
                    case ("stop"):
                        MP3player.stop();
                        break;
                    case ("sort"):
                        musicStorage.sort();
                        break;
                    case ("search"):
                        String keyword = consoleInteractor.readKeyword();
                        musicStorage.search(keyword);
                        break;
                    case ("create playlist"):
                        musicStorage.createPlaylist();
                        break;
                    default:
                        System.out.println("Command not found, sorry, bro");
                        break;
                }
            }
        } catch (UserInteractorReadException | UserInteractorInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
