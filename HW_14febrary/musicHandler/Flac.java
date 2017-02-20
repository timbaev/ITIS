package HW_14febrary.musicHandler;

import HW_14febrary.data.MusicStorage;
import HW_14febrary.entities.Track;

/**
 * Created by Timbaev on 14.02.2017.
 * Flac player
 */
public class Flac implements Player {

    private static Flac FlacPlayer = null;
    private static Track currentSong;

    private Flac() {}

    public static Flac getInstance(Track track) {
        if (FlacPlayer == null) {
            FlacPlayer = new Flac();
        }
        currentSong = track;
        return FlacPlayer;
    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }
}
