package HW_14febrary.musicHandler;

import HW_14febrary.data.MusicStorage;

/**
 * Created by Timbaev on 14.02.2017.
 *
 */
public class MP3 implements Player {

    private boolean isPlay = false;
    private boolean isPause = false;
    private boolean isTrackPicked = false;
    private MusicStorage musicStorage;
    private String currentSong;

    public MP3(MusicStorage musicStorage) {
        this.musicStorage = musicStorage;
    }

    @Override
    public void play() {
        if (isPause) {
            System.out.println("Ok, continue playing: " + currentSong);
            isPause = false;
        } else {
            if (!isPlay) {
                System.out.println("Now playing: " + currentSong);
                isPlay = true;
            } else {
                System.out.println("Music already plays");
            }
        }
    }

    @Override
    public void pause() {
        if (isPlay) {
            System.out.println("Ok, music has been paused");
            isPlay = false;
            isPause = true;
        } else {
            System.out.println("Music not playing");
        }
    }

    @Override
    public void stop() {
        if (isPlay) {
            System.out.println("Music was been stopped");
            isTrackPicked = false;
        } else {
            System.out.println("Music not playing now");
        }
    }

    @Override
    public void pickTrack(int numberOfTrack) {
        currentSong = musicStorage.scan().get(numberOfTrack - 1).getName();
        isTrackPicked = true;
    }

    @Override
    public boolean isTrackPicked() {
        return isTrackPicked;
    }

}
