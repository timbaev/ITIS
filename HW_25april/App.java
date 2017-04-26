package HW_25april;

import java.io.File;

/**
 * Created by Timbaev on 25.04.2017.
 * Main app class
 */
public class App {

    public static void main(String[] args) {
        MIDIPlayer midiPlayer = new MIDIPlayer();
        File file = new File("parameters.midi");
        midiPlayer.playMusic(file);
    }
}
