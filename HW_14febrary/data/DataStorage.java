package HW_14febrary.data;

import HW_14febrary.entities.Track;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by Timbaev on 14.02.2017.
 *
 */
public interface DataStorage {
    public ArrayList<Track> scan(URI folderPath);
    public void remove(URI namePath);
    public void read(URI readPath);
}
