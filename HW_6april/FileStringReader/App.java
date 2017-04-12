package HW_6april.FileStringReader;

import java.util.Scanner;

/**
 * Created by Timbaev on 10.04.2017.
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String string = scanner.nextLine();
        CharacterFileManager.writeCharacters(string);
        System.out.println("Your string from file: " + CharacterFileManager.readCharacters());
    }
}
