package CW_28febrary.Comporator;

import java.util.Comparator;

/**
 * Created by Timbaev on 28.02.2017.
 *
 */
public class TrackComposerComparator implements Comparator<Track> {

    @Override
    public int compare(Track o1, Track o2) {
        return o1.getComposer().compareTo(o2.getComposer());
    }
}
