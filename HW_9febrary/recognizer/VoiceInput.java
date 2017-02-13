package CW_9Febrary.recognizer;

import java.util.Scanner;

/**
 * Created by Timbaev on 13.02.2017.
 * Voice Input Manager
 */
public class VoiceInput {

    private RecognizerManager recognizerManager;

    public VoiceInput() {
        recognizerManager = new RecognizerManager();
    }

    private void startInputVoiceCommand() {
        recognizerManager.getStartListener();
    }

    private void endInputVoiceCommand() {
        recognizerManager.getStopListener();
    }

    private String getVoiceCommand() {
        return recognizerManager.getRecognizeListener();
    }

    public String getCommand() {
        System.out.println("Start input the voice command...");
        System.out.println("Listening...");
        System.out.println("Press enter to end");
        startInputVoiceCommand();
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("")) {
            endInputVoiceCommand();
            System.out.println("Loading...");
            return getVoiceCommand();
        }
        return null;
    }

    public void sayText(Object[] objects) {
        for (Object string : objects) {
            System.out.println("Text to say: " + string.toString());
            recognizerManager.getListenListener(string.toString());
        }
    }
}
