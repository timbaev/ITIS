package HW_7march.userTerminal;

import HW_7march.database.DatabaseUtils;
import HW_7march.entitys.Composer;
import HW_7march.entitys.Track;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Timbaev on 08.03.2017.
 * Main User Terminal
 */
public class UserTerminalManager {

    private Scanner scanner;
    private DatabaseUtils databaseUtils;

    public  UserTerminalManager() {
        scanner = new Scanner(System.in);
        databaseUtils = new DatabaseUtils();
    }

    public String readCommand() {
        System.out.print("Enter the command: ");
        return scanner.nextLine();
    }

    public Track addTrackCommand() {
        try {
            System.out.print("Enter track name: ");
            String name = scanner.nextLine();
            System.out.print("Enter track duration (mm:ss): ");
            LocalTime duration = LocalTime.parse(scanner.nextLine());
            System.out.print("Enter track genre: ");
            String genre = scanner.nextLine();
            Composer composer = createComposer();
            if (composer == null) return null;
            return new Track(name, duration, composer, genre);
        } catch (DateTimeParseException e) {
            System.out.println("Error..duration is not correct!");
        }
        return null;
    }

    public int removeTrackCommand() {
        try {
            System.out.print("Enter number position of track: ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error..position it is a number!");
        }
        return -1;
    }

    public void searchTrackCommand() {
        try {
            boolean print = true;
            ArrayList<Track> tracks = null;
            System.out.print("Enter search type (name/duration/composer): ");
            String typeSearch = scanner.nextLine();
            switch (typeSearch) {
                case "name":
                    System.out.print("Enter name keyword: ");
                    tracks = databaseUtils.searchName(scanner.nextLine());
                    break;
                case "duration":
                    System.out.print("Enter duration (mm:ss): ");
                    LocalTime duration = LocalTime.parse(scanner.nextLine());
                    System.out.print("Enter search type (>/<): ");
                    String type = scanner.nextLine();
                    tracks = databaseUtils.searchDuration(duration, type);
                    break;
                case "composer":
                    System.out.print("Enter composer name or age: ");
                    String composerInfo = scanner.nextLine();
                    if (isInteger(composerInfo)) {
                        tracks = databaseUtils.searchComposer(Integer.parseInt(composerInfo));
                    } else {
                        tracks = databaseUtils.searchComposer(composerInfo);
                    }
                    break;
                default:
                    System.out.println("Error..type not found");
                    print = false;
                    break;
            }
            if (print) InfoPrinter.printInfo(tracks);
        } catch (DateTimeParseException e) {
            System.out.println("Error..duration is not correct");
        } catch (UserTerminalException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sortTrackCommand() {
        ArrayList<Track> tracks = null;
        boolean print = true;
        System.out.print("Enter sort type (name/duration/composer): ");
        String typeSort = scanner.nextLine();
        switch (typeSort) {
            case "name":
                tracks = databaseUtils.sortName();
                break;
            case "duration":
                tracks = databaseUtils.sortDuration();
                break;
            case "composer":
                tracks = databaseUtils.sortComposer();
                break;
            default:
                System.out.println("Error..type not found");
                print = false;
                break;
        }
        if (print) InfoPrinter.printInfo(tracks);
    }

    private boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private Composer createComposer() {
        try {
            System.out.print("Enter composer name: ");
            String name = scanner.nextLine();
            System.out.print("Enter composer age: ");
            String ageStr = scanner.nextLine();
            int age = Integer.parseInt(ageStr);
            return new Composer(name, age);
        } catch (NumberFormatException e) {
            System.out.println("Error..age of composer may be only numbers!");
        }
        return null;
    }
}
