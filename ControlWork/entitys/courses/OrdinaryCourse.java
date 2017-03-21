package ControlWork.entitys.courses;

/**
 * Created by Timbaev on 21.03.2017.
 */
public class OrdinaryCourse implements Course {

    private String name;
    private int scores;

    public OrdinaryCourse(String name) {
        this.name = name;
        scores = 0;
    }

    @Override
    public int getScores() {
        return scores;
    }

    @Override
    public void handOverHW(int scoresHW) {
        if (scores < 50) {
            scores += scoresHW;
        }
    }
}
