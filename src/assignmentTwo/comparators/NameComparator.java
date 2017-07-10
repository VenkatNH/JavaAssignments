package assignmentTwo.comparators;

import assignmentTwo.model.Student;

import java.util.Comparator;

/**
 * Created by venkatdatta on 05/07/17.
 */
public enum NameComparator implements Comparator<Student> {

    INSTANCE;

    public int compare(Student sd1, Student sd2){
            if (sd1.getFullName().compareToIgnoreCase(sd2.getFullName()) == 0) {
                return sd1.getRollNum() - sd2.getRollNum();
            } else
                return sd1.getFullName().compareToIgnoreCase(sd2.getFullName());
    }
}