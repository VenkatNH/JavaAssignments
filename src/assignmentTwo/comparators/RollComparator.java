package assignmentTwo.comparators;

import assignmentTwo.model.Student;

import java.util.Comparator;

/**
 * Created by venkatdatta on 06/07/17.
 */
public enum RollComparator implements Comparator<Student> {
    INSTANCE;
    public int compare(Student sd1, Student sd2){
        return sd1.getRollNum() - sd2.getRollNum();
    }
}