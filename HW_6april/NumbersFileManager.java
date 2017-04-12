package HW_6april;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Timbaev on 06.04.2017.
 * Work with Input and Output Stream`s
 */
public class NumbersFileManager {

    private static File fileNumbers;

    public static void main(String[] args) {
        fileNumbers = new File(Paths.get("Numbers.txt").toUri());
        writeNumbers();
        readNumbers();
    }

    private static void writeNumbers() {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            Random random = new Random();
            numbers[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(numbers));
        try (OutputStream fileOutputStream = new FileOutputStream(fileNumbers)) {
            for (int number : numbers) {
                byte[] bytes = ByteBuffer.allocate(4).putInt(number).array();
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readNumbers() {
        try (InputStream fileInputStream = new FileInputStream(fileNumbers)) {
            int[] numbers = new int[10];
            for (int j = 0; j < 10; j++) {
                byte[] bytes = new byte[4];
                fileInputStream.read(bytes);
                ByteBuffer wrapped = ByteBuffer.wrap(bytes);
                int num = wrapped.getInt();
                numbers[j] = num;
            }
            System.out.println(Arrays.toString(numbers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
