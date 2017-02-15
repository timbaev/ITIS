package HW_14febrary.musicHandler;

/**
 * Created by Timbaev on 14.02.2017.
 *
 */
public interface Player {
    public void play();
    public void pause();
    public void stop();
    public void pickTrack(int numberOfTrack);
    public boolean isTrackPicked();
}
