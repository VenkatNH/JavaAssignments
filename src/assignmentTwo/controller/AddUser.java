package assignmentTwo.controller;

import assignmentTwo.exceptions.InvalidInputException;
import assignmentTwo.model.Student;

import java.util.TreeSet;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class AddUser {

    /* Add User Details to the In-Memory Data Structure */
    public void addUserDetails(TreeSet<Student> studentDB) throws InvalidInputException {
        Student studentObj;
        GetUserInput userInput = new GetUserInput();
        studentObj = userInput.getInput(studentDB);

        studentDB.add(studentObj);
    }
}
