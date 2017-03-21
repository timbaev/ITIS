package ControlWork.entitys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Timbaev on 21.03.2017.
 * Group of students
 */
public class Group implements Iterable<Group> {

    private String numberGroup;
    private List<Student> students;

    public Group(String numberGroup, ArrayList<Student> students) {
        this.numberGroup = numberGroup;
        this.students = students;
    }

    public Group(String numberGroup) {
        this.numberGroup = numberGroup;
        students = new ArrayList<>();
    }

    public void addStudents(Student... newStudents) {
        Collections.addAll(students, newStudents);
    }

    @Override
    public Iterator<Group> iterator() {
        return null;
    }

    private class GroupIterator implements Iterator<Group> {
        int position;

        public GroupIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < students.size();
        }

        @Override
        public Group next() {
            return null;
        }
    }
}
