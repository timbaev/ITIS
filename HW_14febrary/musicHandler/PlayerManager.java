package HW_14febrary.musicHandler;

import HW_14febrary.data.MusicStorage;
import HW_14febrary.entities.Track;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Timbaev on 16.02.2017.
 * PLayer Manager, get a command and send to necessary player
 */
public class PlayerManager {

    private Player player;
    private PlayerFabric playerFabric;
    public static boolean isTrackPicked = false;
    private MusicStorage musicStorage;
    private Track currentSong;

    private Observable observable = new Observable() {
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
        }
    };

    public void addObserver(Observer o) {
        observable.addObserver(o);
    }

    public PlayerManager(MusicStorage musicStorage) {
        this.musicStorage = musicStorage;
        playerFabric = new PlayerFabric(musicStorage);
    }

    public void play() {
        player = playerFabric.getPlayer(currentSong);
        player.play();
        observable.notifyObservers("Playing");
    }

    public void pause() {
        player.pause();
        observable.notifyObservers("Pause");
    }

    public void stop() {
        player.stop();
        observable.notifyObservers("Stop");
    }

    public void pickTrack(int numberOfTrack) {
        currentSong = musicStorage.scan().get(numberOfTrack - 1);
        isTrackPicked = true;
    }

    public boolean isTrackPicked() {
        return isTrackPicked;
    }
}
