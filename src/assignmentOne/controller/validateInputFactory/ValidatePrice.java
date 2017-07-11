package assignmentOne.controller.validateInputFactory;

import assignmentOne.InvalidInputException;
import assignmentOne.controller.ValidateInput;
import assignmentOne.model.ItemProperties;
import assignmentOne.model.Regex;

import java.util.regex.Pattern;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class ValidatePrice implements ValidateInput {

    @Override
    public int validate(String data[]) throws InvalidInputException {
        if (data[0].equalsIgnoreCase(ItemProperties.PRICE)) {
            if (!Pattern.matches(Regex.DOUBLE, data[1])) {
                throw new InvalidInputException("--price needs to be numeral");
            }
            return 3;

        }
        return -1;
    }
}
