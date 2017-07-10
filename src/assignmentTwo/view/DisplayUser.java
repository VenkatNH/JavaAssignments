package assignmentTwo.view;

import assignmentTwo.comparators.AddressComparator;
import assignmentTwo.comparators.AgeComparator;
import assignmentTwo.comparators.RollComparator;
import assignmentTwo.model.Student;

import java.util.Scanner;
import java.util.TreeSet;

import assignmentTwo.model.StudentProperties;


/**
 * Created by venkatdatta on 06/07/17.
 */
class DisplayUser {

    /* Displays the User Input in a defined format */
    void displayUserDetails(TreeSet<Student> studentDB) {

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println(" Name               Roll Number              Age             Address            Course     ");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Student entry : studentDB) {
            System.out.printf(" %-20s   %-20d %-12d %-20s  %-20s \n",
                    entry.getFullName(),
                    entry.getRollNum(),
                    entry.getAge(),
                    entry.getAddress(),
                    entry.course.getCourses());

        }
        System.out.println("===================================================================================");

        viewByParameter(studentDB);

    }

    /* Function sorts the Input According to the Given Parameter */
    private void viewByParameter(TreeSet<Student> studentDB){
        Scanner in = new Scanner(System.in);
        TreeSet<Student> temp;
        System.out.println("Sort the Data in Descending Order (y/n) :");
        if(in.next().charAt(0) == 'y'){

            System.out.println("Sort Data By ( name : 0 ,age : 1 , address : 2 , rollnumber : 3");
            switch (in.next().charAt(0)){
                case StudentProperties.STUDENT_NAME :
                    temp = studentDB;
                    break;
                case StudentProperties.STUDENT_ADDRESS:
                    temp = new TreeSet<>(AddressComparator.INSTANCE);
                    temp.addAll(studentDB);
                    break;
                case StudentProperties.STUDENT_AGE:
                    temp = new TreeSet<>(AgeComparator.INSTANCE);
                    temp.addAll(studentDB);
                    break;
                case StudentProperties.STUDENT_ROLL:
                    temp = new TreeSet<>(RollComparator.INSTANCE);
                    temp.addAll(studentDB);
                    break;
                default:
                    temp = studentDB;
            }


            assert temp != null;
            displayUserDetails((TreeSet<Student>)temp.descendingSet());
        }
    }

}

