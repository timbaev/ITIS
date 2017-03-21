package ControlWork.entitys.courses;

/**
 * Created by Timbaev on 21.03.2017.
 */
public class ExaminationCourse implements Course {

    private String name;
    private int scores;

    @Override
    public int getScores() {
        return scores;
    }

    @Override
    public void handOverHW(int scoresHW) {
        if (scores < 100) {
            scores += scoresHW * 0.5;
        }
    }

    public void passControlWork(int solvedTasksCount) {
        if (scores < 50) scores += solvedTasksCount * 3.75;
    }

    public void passIndependentWork(int solvedTasksCount) {
        if (scores < 50) scores += solvedTasksCount * 2.15;
    }

    public void passExam(int solvedTasksCount) {
        if (solvedTasksCount <= 4  && solvedTasksCount >= 0) {
            if (scores > 50) scores += solvedTasksCount * 12.5;
        } else {
            System.out.println("Oups..incorrect counts of tasks");
        }
    }
}
