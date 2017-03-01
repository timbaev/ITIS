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

    public static <T> EndlessArray<T> copyOfRange(EndlessArray<T> array, int from, int to) {
        if (from < 0 || from > array.size()) throw new ArrayIndexOutOfBoundsException("from < 0 or from > original.length()");
        if (from > to) throw new IllegalArgumentException("from > to");
        EndlessArray<T> newArray = new EndlessArray<T>();
        for (int i = from; i <= to; i++) {
            newArray.add(array.get(i));
        }
        return newArray;
    }

    public static <T> String toStringEndlessArray(EndlessArray<T> array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            stringBuilder.append(array.get(i) + "; ");
        }
        return stringBuilder.toString();
    }
}
