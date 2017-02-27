package HW_21febrary;

import java.util.Arrays;

/**
 * Created by Timbaev on 21.02.2017.
 * Test EndlessArray
 */
public class App {

    public static void main(String[] args) {
        EndlessArray<String> array = new EndlessArray<>();
        array.add("Test String");
        array.add("New String");
        array.add("ITIS");

        System.out.println("get(2): " + array.get(2));
        array.remove(1);
        for (int i = 0; i < 2; i++) {
            System.out.println("get(" + i + "): " + array.get(i));
        }
        System.out.println("___________________________");
        testFillArray();
    }

    private static void testFillArray() {
        String[] itisArray = new String[10];
        ArrayUtils.fill(itisArray, "ITIS");
        System.out.println(Arrays.toString(itisArray));
    }
}
