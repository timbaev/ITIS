package ControlWork.entitys;

import ControlWork.entitys.courses.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timbaev on 21.03.2017.
 */
public class Student {

    private String name;
    private String surname;
    private int age;
    private String group;
    private int averageScore;
    private List<Course> courses;
    private int sumScores;

    public Student(String name, String surname, int age, String group) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.group = group;
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    private int averageScoreCount() {
        int sum = 0;
        for (Course course : courses) {
            sum += course.getScores();
        }
        sum = sum/courses.size();
        return sum;
    }

    public int getAverageScore() {
        return averageScoreCount();
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getSumScores() {
        int sum = 0;
        for (Course course : courses) {
            sum += course.getScores();
        }
        return sum;
    }
}
