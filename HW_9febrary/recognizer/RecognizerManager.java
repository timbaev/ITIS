package CW_9Febrary.recognizer;

import javax.sound.sampled.Mixer;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Timbaev on 13.02.2017.
 * Recognizer Manager
 */
public class RecognizerManager {

    private AudioCapture audioCapture;
    private AudioPlay audioPlay;

    public String getRecognizeListener() {
        if (audioCapture.isCapture()) {
            return null;
        }

        if (audioCapture == null) {
            System.out.println("You should record voice at first");
            return null;
        }
        byte[] data = audioCapture.getAudioBytes();
        if (data.length > 0) {

            try {
                ArrayList<String> recText = SpeechKit.sendPOST(data);
                if (recText.size() != 0) {
                    audioCapture.closeAudioCapture();
                    return recText.get(0);
                } else {
                    throw new RecognitionSpeechException("Record error, please, try again!");
                }
            } catch (RecognitionSpeechException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("You should record some audio before sending");
        }
        return null;
    }

    public void getListenListener(String text) {
        if (text == null || text.equals("")) {
            System.out.println("too few symbols in text");
            return;
        }

        try {
            byte[] bytes = SpeechKit.sendGET(text);

            audioPlay = new AudioPlay(bytes);
        } catch (TextRecognitionException | AudioPlayException e1) {
            System.out.println("Exception :c");
            e1.printStackTrace();
        }
    }

    public void getStartListener() {
        if (audioPlay != null && audioPlay.isAudioPlay()) {
            return;
        }

        try {
            audioCapture = new AudioCapture();
        } catch (AudioCaptureException e) {
            System.out.println("Error capture audio..");
            e.printStackTrace();
        }
    }

    public void getStopListener() {
        audioCapture.setCapture(false);
    }
}
