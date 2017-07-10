package assignmentOne.controller;

import assignmentOne.InvalidInputException;
import assignmentOne.model.ItemProperties;
import assignmentOne.model.ItemType;
import assignmentOne.model.Regex;

import java.util.regex.Pattern;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class ValidateInput {

    public void validateArgument(String args[]) throws InvalidInputException {
        if (args == null || args.length < 1) {
            throw new InvalidInputException("Missing Arguments");
        }

        if (args[0].compareTo(ItemProperties.NAME) != 0)
            throw new InvalidInputException("Expecting --name parameter");
    }

    boolean validateName(String data[]) throws InvalidInputException{
        if(data[0].equalsIgnoreCase(ItemProperties.NAME)){
            if (!data[1].equals("")) {
                return true;
            } else {
                throw new InvalidInputException(" --name Invalid Value");
            }
        }
        return false;
    }

    boolean validateItemType(String data[]) throws InvalidInputException{
        if (data[0].equalsIgnoreCase(ItemProperties.TYPE)) {
            if (data[1].equals(ItemType.RAW) || data[1].equals(ItemType.MANUFACTURED) || data[1].equals(ItemType.IMPORTED)) {
                return true;
            } else {
                throw new InvalidInputException("--type Invalid Value ");
            }
        }
        return false;
    }

    boolean validateQuantity(String data[]) throws InvalidInputException{
        if (data[0].equalsIgnoreCase(ItemProperties.QUANTITY)) {
            if (!Pattern.matches(Regex.INT, data[1])) {

                throw new InvalidInputException("--quantity needs to be a numeral");
            }
            return true;

        }
        return false;
    }

    boolean validatePrice(String data[]) throws InvalidInputException{
        if (data[0].equalsIgnoreCase(ItemProperties.PRICE)) {
            if (!Pattern.matches(Regex.DOUBLE, data[1])) {
                throw new InvalidInputException("--price needs to be numeral");
            }
            return true;

        }
        return false;
    }

}
