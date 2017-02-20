package HW_14febrary.data;

import HW_14febrary.entities.Track;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Timbaev on 14.02.2017.
 *
 */
public class MusicStorage {

    private DataStorage dataStorage;
    private ArrayList<Track> tracks;

    public MusicStorage() {
        dataStorage = new InternalDataStorage();
        tracks = new ArrayList<>();
    }


    public ArrayList<Track> scan() {
        try {
            tracks = dataStorage.scan(new URI("file:///C:/Music"));
            return tracks;
        } catch (URISyntaxException e) {
            System.out.println("Error..path not correct");
            e.printStackTrace();
        }
        return null;
    }

//    public void sort() {
//        Collections.sort(tracks, new Comparator<Track>() {
//            @Override
//            public int compare(Track track1, Track track2) {
//                return track1.getName().compareTo(track2.getName());
//            }
//        });
//    }

    public void sort() {
        Collections.sort(tracks, (track1, track2) -> track1.getName().compareTo(track2.getName()));
    }

    //TODO исправить регистр
    public void search(String keyword) {
        int numberOfTrack = 0;
        for (Track track : tracks) {
            numberOfTrack++;
            String trackName = track.getName();
            if (trackName.contains(keyword)) {
                System.out.println(numberOfTrack + "." + " " + trackName);
            }
        }
    }

    public void createPlaylist() {
        scan();
        int numberOfTrack = 0;
        for (Track track : tracks) {
            numberOfTrack++;
            System.out.println(numberOfTrack + "." + " " + track.getName());
        }
    }

}
