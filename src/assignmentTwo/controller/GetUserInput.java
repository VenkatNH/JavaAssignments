package assignmentTwo.controller;

import assignmentTwo.exceptions.InvalidInputException;
import assignmentTwo.model.Regex;
import assignmentTwo.model.Student;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by venkatdatta on 06/07/17.
 */
class GetUserInput {
    /* Function takes the Input from the User */
    Student getInput(TreeSet<Student> studentDB) throws InvalidInputException {

        Scanner in = new Scanner(System.in);

        Student studentObj = new Student();
        studentObj.setFullName(getUserName(in));
        studentObj.setAge(getAge(in));
        studentObj.setAddress(getAddress(in));
        studentObj.setRollNum(getRollNumber(in, studentDB));
        studentObj.course.setCourses(getCourses(in));

        return studentObj;
    }

    /* Get the User Name Details From the User */
    private String getUserName(Scanner in) throws InvalidInputException {
        String data;
        System.out.println("Enter Name :");
        data = in.nextLine();
        ValidateData validateData = new ValidateData();

        if (validateData.validateName(data)) {
            return data;
        } else {
            throw new InvalidInputException("Full Name : Invalid Value ");
        }

    }

    /* Get the Age Details From the User */
    private int getAge(Scanner in) throws InvalidInputException {
        String data;
        ValidateData validateData = new ValidateData();
        System.out.println("Enter Age :");
        data = in.nextLine();

        if (validateData.validateAge(data)) {
            return Integer.parseInt(data);
        } else {
            throw new InvalidInputException("Age : Invalid Value ");
        }
    }

    /* Get Address Details From the User */
    private String getAddress(Scanner in) throws InvalidInputException {
        String data;
        ValidateData validateData = new ValidateData();

        System.out.println("Enter Address :");
        data = in.nextLine();

        if (validateData.validateAddress(data)) {
            return data;
        } else {
            throw new InvalidInputException("Address : Invalid Value");
        }
    }

    /* Get Valid Roll Number From the User */
    private String getRollNumber(Scanner in, TreeSet<Student> studentDB) throws InvalidInputException {
        String data;
        ValidateData validateData = new ValidateData();
        System.out.println("Enter Roll Num :");
        data = in.nextLine();

        if (validateData.validateRollNum(studentDB, data)) {
            return data;
        } else {
            throw new InvalidInputException("Roll Num : Invalid Value ");
        }

    }


    /* Get the Courses Details From the User */
    private String[] getCourses(Scanner in) throws InvalidInputException {
        ValidateData validateData = new ValidateData();
        System.out.println("Enter Courses : ( Hint : A B C D E ) ");
        String courses[] = in.nextLine().split(Regex.WHITESPACE);
        if (validateData.validateCourses(courses)) {
            return courses;
        } else {
            throw new InvalidInputException("4 Mandatory Courses");
        }
    }

}
