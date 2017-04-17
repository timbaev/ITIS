package HW_13april;

import HW_13april.CSVReader.CSVManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by Timbaev on 13.04.2017.
 *
 */
public class App {

    public static void main(String[] args) {
        CSVManager manager = new CSVManager(new File(Paths.get("C:\\Test\\csv.csv").toUri()));
        try {
            manager.setDelimiter(",");
            manager.writeFile(new String[][] {{"ITIS", "Test"}, {"Hello, World!", "Test"}});
            String[][] data = manager.readFile();
            for (String[] aData : data) {
                System.out.println(Arrays.toString(aData));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
