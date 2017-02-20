package HW_14febrary.musicHandler;

import HW_14febrary.data.MusicStorage;
import HW_14febrary.entities.Track;

/**
 * Created by Timbaev on 14.02.2017.
 * WAV player
 */
public class WAV implements Player {

    private static WAV WAVPlayer = null;
    private static Track currentSong;

    private WAV() {}

    public static WAV getInstance(Track track) {
        if (WAVPlayer == null) {
            WAVPlayer = new WAV();
        }
        currentSong = track;
        return WAVPlayer;
    }

    @Override
    public void play() {
        System.out.println("Ok, now I playing a WAV file");
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }
}
