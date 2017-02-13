package CW_9Febrary.recognizer;

import javax.sound.sampled.AudioFormat;

/**
 * This is AudioFormatUtil class
 * Here you should set up
 */
public class AudioFormatUtil {

    /**
     * AudiFormat
     */

    private static float SAMPLE_RATE = 16000.0f;
    private static int SAMPLE_SIZE_IN_BITS = 16;
    private static int CHANNELS = 1;
    private static boolean SIGNED = true;
    private static boolean BIG_ENDIAN = false;

    public static AudioFormat getAudioFormat(){

        return new AudioFormat(SAMPLE_RATE,SAMPLE_SIZE_IN_BITS,CHANNELS,SIGNED,BIG_ENDIAN);
    }

    public static AudioFormat getAudioSayFormat() {
        SAMPLE_RATE = 48000.0f;
        return new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE_IN_BITS, CHANNELS, SIGNED, BIG_ENDIAN);
    }

}
