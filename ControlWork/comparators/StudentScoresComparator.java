package ControlWork.comparators;

import ControlWork.entitys.Student;

import java.util.Comparator;

/**
 * Created by Timbaev on 21.03.2017.
 */
public class StudentScoresComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return ((Integer) o1.getSumScores()).compareTo(o2.getSumScores());
    }
}
