package CW_9Febrary.recognizer;

public class RecognitionSpeechException extends Exception {

    public RecognitionSpeechException() {
    }

    public RecognitionSpeechException(String message) {
        super(message);
    }

    public RecognitionSpeechException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecognitionSpeechException(Throwable cause) {
        super(cause);
    }
}
