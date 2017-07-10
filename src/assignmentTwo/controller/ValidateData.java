package assignmentTwo.controller;

import assignmentTwo.exceptions.InvalidInputException;
import assignmentTwo.model.Regex;
import assignmentTwo.model.Student;

import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Created by venkatdatta on 06/07/17.
 */
class ValidateData {
    /* Validate Roll Number to Check if it is a Number and the Value Does Not Exist Before */
     boolean validateRollNum(TreeSet<Student> obj, String data)throws InvalidInputException {
        if(data != null && Pattern.matches(Regex.INT, data)) {
            for (Student student : obj) {
                if (student.getRollNum() == Integer.parseInt(data)){
                    throw new InvalidInputException("Roll Number already exists");

                }

            }
        }else
            return false;
        return true;
    }
    /* Validate Courses To Check for 4 Mandatory Courses */
     boolean validateCourses(String val[]) throws InvalidInputException{
        if(val.length < 4)
            throw new InvalidInputException(" 4 Courses are Mandatory");
        for(int i = 0; i < val.length ; i++){

            if(val[i].length() >= 1 && (val[i].charAt(0) - 'A' > 6  || val[i].charAt(0) - 'A' < 0 )){
                throw new InvalidInputException("Course Invalid . Acceptable Courses A,B,C,D,E,F");
            }
        }
        return true;
    }
    /* Validates the User Name Details */
    boolean validateName(String data){
        if(data != null && !data.equals(""))
            return true;
        return false;
    }

    boolean validateAge(String data){
        /* Validates the User Age Details */
        if(data != null && Pattern.matches(Regex.INT, data)){
            return true;
        }
        return false;
    }

    boolean validateAddress(String data){
        /* Validates the User Address Details */
        if(data != null && !data.equals("")){
            return true;
        }
        return false;
    }


}
