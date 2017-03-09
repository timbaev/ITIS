package HW_7march.database;

import HW_7march.entitys.Composer;
import HW_7march.entitys.Track;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by Timbaev on 08.03.2017.
 * Database for tracks
 */
public class Database {

    private ArrayList<Track> tracks;
    private final String databaseFile = "database.txt";
    private static Database database;

    private Database() {
        tracks = readDataFromFile();
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public void addTrack(Track track) {
        tracks.add(track);
        updateFile();
    }

    public void removeTrack(int position) {
        tracks.remove(position);
        updateFile();
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    private void updateFile() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(databaseFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Track track;
        String row;
        for (Track track1 : tracks) {
            track = track1;
            row = track.getName() + ", " + track.getDuration() + ", " + track.getComposer().getName() + ", "
                    + track.getComposer().getAge() + ", " + track.getGenre();
            try {
                assert bufferedWriter != null;
                bufferedWriter.write(row);
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if (bufferedWriter != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Track> readDataFromFile() {
        ArrayList<Track> tracks = new ArrayList<>();
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(databaseFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            String[] tokens;
            while ((strLine = br.readLine()) != null) {
                tokens = strLine.split(", ");
                String name = tokens[0];
                LocalTime duration = LocalTime.parse(tokens[1]);
                Composer composer = new Composer(tokens[2], Integer.parseInt(tokens[3]));
                String genre = tokens[4];
                Track track = new Track(name, duration, composer, genre);
                tracks.add(track);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert fstream != null;
                fstream.close();
            } catch (Exception ignored) {}
        }
        return tracks;
    }
}
