package HW_21febrary;

/**
 * Created by Timbaev on 27.02.2017.
 * Utils for arrays
 */
public class ArrayUtils {

    public static <T> void fill(T[] array, T obj) {
        for (int i = 0; i < array.length; i++) {
            array[i] = obj;
        }
    }
}
