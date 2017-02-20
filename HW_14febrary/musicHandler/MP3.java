package HW_14febrary.musicHandler;

import HW_14febrary.entities.Track;

/**
 * Created by Timbaev on 14.02.2017.
 *
 */
public class MP3 implements Player {

    private boolean isPlay = false;
    private boolean isPause = false;
    private static MP3 MP3Player = null;
    private static Track currentSong;

    private MP3() {}

    public static MP3 getInstance(Track track) {
        if (MP3Player == null) {
            MP3Player = new MP3();
        }
        currentSong = track;
        return MP3Player;
    }

    @Override
    public void play() {
        if (isPause) {
            System.out.println("Ok, continue playing: " + currentSong.getName());
            isPause = false;
            isPlay = true;
        } else {
            if (!isPlay) {
                System.out.println("Now playing: " + currentSong.getName());
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
        if (isPlay || isPause) {
            System.out.println("Music was been stopped");
            PlayerManager.isTrackPicked = false;
            isPlay = false;
            isPause = false;
        } else {
            System.out.println("Music not playing now");
        }
    }

}
