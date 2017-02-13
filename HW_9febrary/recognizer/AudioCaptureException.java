package CW_9Febrary.recognizer;

public class AudioCaptureException extends Exception {

    public AudioCaptureException() {
    }

    public AudioCaptureException(String message) {
        super(message);
    }

    public AudioCaptureException(String message, Throwable cause) {
        super(message, cause);
    }

    public AudioCaptureException(Throwable cause) {
        super(cause);
    }
}
