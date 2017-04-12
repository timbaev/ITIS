package HW_6april;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Timbaev on 10.04.2017.
 *
 */
public class ImageFormatReader {

    public static void main(String[] args) {
        File file;
        while (true) {
            file = new File(Paths.get(getPath()).toUri());
            if (file.isFile()) break;
            System.out.println("Whooops..path is not correct, enter again!");
        }
        try {
            String type = Files.probeContentType(file.toPath());
            System.out.println("Type of image is: " + type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to image: ");
        return scanner.nextLine();
    }
}
