package assignmentTwo;

/**
 * Created by venkatdatta on 05/07/17.
 */

import assignmentTwo.comparators.NameComparator;
import assignmentTwo.controller.UserDetails;
import assignmentTwo.model.StudentDB;
import assignmentTwo.view.Menu;

import java.util.TreeSet;
public class AssignmentTwo {

    public static void main(String args[]){
        StudentDB database;

        UserDetails userDetails = new UserDetails();
        database = userDetails.loadUserDetails();

        if(database == null) {
            database = new StudentDB();
            database.studentDB = new TreeSet<>(NameComparator.INSTANCE);
        }

        Menu menu = new Menu();

        menu.displayMenu(database);

    }
}

