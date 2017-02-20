package HW_14febrary.musicHandler;

import HW_14febrary.data.MusicStorage;
import HW_14febrary.entities.Track;

/**
 * Created by Timbaev on 16.02.2017.
 *
 */
public class PlayerFabric {

    private MusicStorage musicStorage;

    public PlayerFabric(MusicStorage musicStorage) {
        this.musicStorage = musicStorage;
    }

    public Player getPlayer(Track track) {
        String format = track.getFormat();
        Player player;
        switch (format) {
            case ("mp3"):
                player = MP3.getInstance(track);
                break;
            case ("wav"):
                player = WAV.getInstance(track);
                break;
            case ("flac"):
                player = Flac.getInstance(track);
                break;
            default:
                System.out.println("Format is not supported");
                player = null;
                break;
        }
        return player;
    }
}
