package HW_13april.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timbaev on 13.04.2017.
 * Library for CSV files
 */
public class CSVManager {

    private File file;
    private String delimiter = ",";

    public CSVManager(File csvFile) {
        this.file = csvFile;
    }

    public String[][] readFile() throws IOException {
        List<String[]> arrayOfStrings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\"" + delimiter + "\"");
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].replaceAll("\\\\\"", "\"");
            }
            data[0] = data[0].replaceFirst("\"", "");
            data[data.length - 1] = data[data.length - 1].replace("\"", "");
            arrayOfStrings.add(data);
        }
        String[][] separatedLines = new String[arrayOfStrings.size()][arrayOfStrings.get(0).length];
        return arrayOfStrings.toArray(separatedLines);
    }

    public void writeFile(String[][] format) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        for (String[] strings : format) {
            for (int j = 0; j < strings.length - 1; j++) {
                String string = strings[j];
                string = string.replaceAll("\"", "\\\\\"");
                writer.write("\"" + string + "\"" + delimiter);
            }
            writer.write("\"" + strings[strings.length - 1] + "\"");
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
