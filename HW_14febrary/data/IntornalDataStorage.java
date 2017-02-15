package HW_14febrary.data;

import HW_14febrary.entities.Track;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by Timbaev on 14.02.2017.
 *
 */
public class IntornalDataStorage implements DataStorage {

    private ArrayList<Track> tracks;

    public IntornalDataStorage() {
        tracks = new ArrayList<>();
    }

    @Override
    public ArrayList<Track> scan(URI folderPath) {
        final File folder = new File(folderPath);
        File[] listFiles = folder.listFiles();
        if (listFiles != null) {
            for (final File fileEntry : listFiles) {
                if (fileEntry.isDirectory()) {
                    scan(fileEntry.toURI());
                } else {
                    String name = fileEntry.getName();
                    String format = FilenameUtils.getExtension(name);
                    Track track = new Track(name, format);
                    tracks.add(track);
                }
            }
        }
        return tracks;
    }

    @Override
    public void remove(URI namePath) {

    }

    @Override
    public void read(URI readPath) {

    }

}
