package HW_7march.userTerminal;

import HW_7march.entitys.Track;

import java.util.ArrayList;

/**
 * Created by Timbaev on 09.03.2017.
 * Printer info
 */
public class InfoPrinter {

    public static void printInfo(ArrayList<Track> tracks) {
        if (tracks != null) {
            if (tracks.size() == 0) {
                System.out.println("Tracks not found");
                return;
            }
            for (int i = 0; i < tracks.size(); i++) {
                System.out.println(i + ". " + tracks.get(i).toString());
            }
        } else {
            System.out.println("Tracks not found");
        }
    }
}
