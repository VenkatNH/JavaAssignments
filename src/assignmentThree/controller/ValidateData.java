package assignmentThree.controller;

import assignmentThree.model.Regex;

import java.util.regex.Pattern;

/**
 * Created by venkatdatta on 06/07/17.
 */
class ValidateData {
    boolean validateInt(String data){
        if(data != null && Pattern.matches(Regex.INT, data)){
            return true;
        }
        return false;

    }
    boolean validateString(String data){
        if(data != null && !data.equals(""))
            return true;
        return false;
    }

}
