package HW_7march.comparators;

import HW_7march.entitys.Track;

import java.util.Comparator;

public class TrackComposerComparator implements Comparator<Track> {

    @Override
    public int compare(Track o1, Track o2) {
        return o1.getComposer().compareTo(o2.getComposer());
    }
}
