package HW_6april.FileStringReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by Timbaev on 10.04.2017.
 *
 */
public class CharacterFileManager {

    public static void writeCharacters(String line) {
        try (Writer fileWriter = new java.io.FileWriter("Characters.txt", false)) {
            fileWriter.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readCharacters() {
        try (Reader fileReader = new FileReader("Characters.txt")) {
            int symbol;
            StringBuilder line = new StringBuilder();
            while((symbol = fileReader.read()) != -1) {
                line.append((char) symbol);
            }
            return line.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
