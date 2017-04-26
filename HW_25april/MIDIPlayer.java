package HW_25april;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Timbaev on 26.04.2017.
 * MIDI player
 */
public class MIDIPlayer {

    private Synthesizer synthesizer;

    public MIDIPlayer() {
        try {
            synthesizer = MidiSystem.getSynthesizer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playMusic(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            synthesizer.open();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parameters = line.split(":");
                int[] parametersInt = new int[4];
                for (int i = 0; i < parameters.length; i++) {
                    parametersInt[i] = Integer.parseInt(parameters[i]);
                }
                playNote(parametersInt[0], parametersInt[1], parametersInt[2], parametersInt[3]);
            }
            synthesizer.close();
        } catch (IOException | MidiUnavailableException e) {
            e.printStackTrace();
        } catch (MIDIPlayerException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error..you write a string in file :c");
        }
    }

    private void playNote(int duration, int note, int volume, int instrument) throws MIDIPlayerException {
        if (note > 127 || note < 0 || volume > 127 || volume < 0 || instrument > 128 || instrument < 1)
            throw new MIDIPlayerException("Error play note with parameters: " + "\n"
                                        + "Duration: " + duration + "\n"
                                        + "Note number: " + note + "\n"
                                        + "Volume: " + volume + "\n"
                                        + "Instrument: " + instrument);
        try {
            MidiChannel[] channels = synthesizer.getChannels();
            channels[0].programChange(instrument);
            channels[0].noteOn(note, volume);
            Thread.sleep(duration);
            channels[0].noteOff(note);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
