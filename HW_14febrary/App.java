package HW_14febrary;

import HW_14febrary.UI.ConsoleUserInteractor;
import HW_14febrary.UI.UserInteractor;
import HW_14febrary.UI.exceptions.UserInteractorInputException;
import HW_14febrary.UI.exceptions.UserInteractorReadException;
import HW_14febrary.data.MusicStorage;
import HW_14febrary.musicHandler.MP3;
import HW_14febrary.musicHandler.Player;
import HW_14febrary.musicHandler.PlayerManager;
import com.google.inject.Singleton;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Timbaev on 14.02.2017.
 * Main app for Music Player
 */
public class App extends Application implements Observer {

    private UserInteractor consoleInteractor;
    private MusicStorage musicStorage;
    private PlayerManager player;
    private String currentState;

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
        player = new PlayerManager(musicStorage);
        player.addObserver(this);
        currentState = "None";
    }

    @Override
    public void start() {
        try {
            String command;
            while (true) {
                System.out.println("Current state: " + currentState);
                command = consoleInteractor.readCommand();
                switch (command) {
                    case ("exit"):
                        System.out.print("Close the program");
                        System.exit(0);
                        break;
                    case ("play"):
                        if (!player.isTrackPicked()) {
                            player.pickTrack(consoleInteractor.readTrackNumber());
                        }
                        player.play();
                        break;
                    case ("pause"):
                        player.pause();
                        break;
                    case ("stop"):
                        player.stop();
                        break;
                    case ("sort"):
                        musicStorage.sort();
                        break;
                    case ("search"):
                        String keyword = consoleInteractor.readKeyword();
                        musicStorage.search(keyword);
                        break;
                    case ("playlist"):
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

    @Override
    public void update(Observable o, Object arg) {
        currentState = arg.toString();
    }
}
