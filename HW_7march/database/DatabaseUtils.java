package HW_7march.database;

import HW_7march.comparators.TrackComposerComparator;
import HW_7march.comparators.TrackDurationComparator;
import HW_7march.comparators.TrackNameComparator;
import HW_7march.entitys.Track;
import HW_7march.userTerminal.UserTerminalException;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Timbaev on 09.03.2017.
 * Utils for database
 */
public class DatabaseUtils {

    private ArrayList<Track> tracks;
    private ArrayList<Track> detectedTracks;

    public DatabaseUtils() {
        tracks = getTracks();
        detectedTracks = new ArrayList<>();
    }

    public ArrayList<Track> searchName(String name) {
        detectedTracks.clear();
        for (Track track : tracks) {
            if (track.getName().contains(name)) {
                detectedTracks.add(track);
            }
        }
        return detectedTracks;
    }

    public ArrayList<Track> searchDuration(LocalTime duration, String type) throws UserTerminalException, DateTimeParseException {
        detectedTracks.clear();
        if (!(type.equals("<") || type.equals(">"))) throw new UserTerminalException("Error..type can only '>' or '<'");
        for (Track track : tracks) {
            if (type.equals(">")) {
                if (track.getDuration().isAfter(duration)) {
                    detectedTracks.add(track);
                }
            }
            if (type.equals("<")) {
                if (track.getDuration().isBefore(duration)) {
                    detectedTracks.add(track);
                }
            }
        }
        return detectedTracks;
    }

    public ArrayList<Track> searchComposer(String composer) {
        detectedTracks.clear();
        for (Track track : tracks) {
            if (track.getComposer().getName().contains(composer)) {
                detectedTracks.add(track);
            }
        }
        return detectedTracks;
    }

    public ArrayList<Track> searchComposer(int age) {
        detectedTracks.clear();
        for (Track track : tracks) {
            if (track.getComposer().getAge() == age) {
                detectedTracks.add(track);
            }
        }
        return detectedTracks;
    }

    public ArrayList<Track> sortName() {
        detectedTracks.clear();
        detectedTracks.addAll(tracks);
        Collections.sort(detectedTracks, new TrackNameComparator());
        return detectedTracks;
    }

    public ArrayList<Track> sortDuration() {
        detectedTracks.clear();
        detectedTracks.addAll(tracks);
        Collections.sort(detectedTracks, new TrackDurationComparator());
        return detectedTracks;
    }

    public ArrayList<Track> sortComposer() {
        detectedTracks.clear();
        detectedTracks.addAll(tracks);
        Collections.sort(detectedTracks, new TrackComposerComparator());
        return detectedTracks;
    }

    private ArrayList<Track> getTracks() {
        Database database = Database.getInstance();
        return database.getTracks();
    }
}
