package assignmentTwo.comparators;
import assignmentTwo.model.Student;

import java.util.Comparator;

/**
 * Created by venkatdatta on 05/07/17.
 */
public enum AddressComparator implements Comparator<Student> {
    INSTANCE;
    public int compare(Student sd1, Student sd2){
        if(sd1.getAddress().compareToIgnoreCase(sd2.getAddress()) == 0){
            return sd1.getRollNum() - sd2.getRollNum();
        }else
            return sd1.getAddress().compareToIgnoreCase(sd2.getAddress());
    }
}