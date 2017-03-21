package ControlWork.comparators;

import java.util.Comparator;
import java.util.InputMismatchException;

/**
 * Created by Timbaev on 21.03.2017.
 */
public class FabricComparator {

    public static Comparator getStudentComparator(String compareType) {
        switch (compareType) {
            case "group":
                return new StudentGroupComparator();
            case "name":
                return new StudentNameComparator();
            case "scores":
                return new StudentScoresComparator();
            default:
                throw new InputMismatchException("Error..type comparator not found");
        }
    }
}
