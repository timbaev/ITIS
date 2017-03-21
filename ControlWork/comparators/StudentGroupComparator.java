package ControlWork.comparators;

import ControlWork.entitys.Student;

import java.util.Comparator;

/**
 * Created by Timbaev on 21.03.2017.
 */
public class StudentGroupComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGroup().compareTo(o2.getGroup());
    }
}
