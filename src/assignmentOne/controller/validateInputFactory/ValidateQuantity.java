package assignmentOne.controller.validateInputFactory;

import assignmentOne.InvalidInputException;
import assignmentOne.controller.ValidateInput;
import assignmentOne.model.ItemProperties;
import assignmentOne.model.Regex;

import java.util.regex.Pattern;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class ValidateQuantity implements ValidateInput {

    @Override
    public int validate(String data[]) throws InvalidInputException {
        if (data[0].equalsIgnoreCase(ItemProperties.QUANTITY)) {
            if (!Pattern.matches(Regex.INT, data[1])) {

                throw new InvalidInputException("--quantity needs to be a numeral");
            }
            return 2;

        }
        return -1;
    }
}
