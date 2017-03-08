package CW_28febrary.Comporator;

import java.util.Comparator;

/**
 * Created by Timbaev on 28.02.2017.
 *
 */
public class TrackDurationComparator implements Comparator<Track> {

    @Override
    public int compare(Track o1, Track o2) {
        return ((Integer) o1.getDuration()).compareTo(o2.getDuration());
    }
}
