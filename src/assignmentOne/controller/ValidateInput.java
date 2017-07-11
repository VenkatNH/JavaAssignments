package assignmentOne.controller;

import assignmentOne.InvalidInputException;
import assignmentOne.model.ItemProperties;
import assignmentOne.model.ItemType;
import assignmentOne.model.Regex;

import java.util.regex.Pattern;

/**
 * Created by venkatdatta on 06/07/17.
 */
public interface ValidateInput {

    int validate(String data[]) throws InvalidInputException;

}
