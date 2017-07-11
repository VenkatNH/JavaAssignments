package assignmentOne.controller.validateInputFactory;

import assignmentOne.InvalidInputException;
import assignmentOne.model.ItemProperties;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class ValidateArgument {

    public void validateArgument(String args[]) throws InvalidInputException {
        if (args == null || args.length < 1) {
            throw new InvalidInputException("Missing Arguments");
        }

        if (args[0].compareTo(ItemProperties.NAME) != 0)
            throw new InvalidInputException("Expecting --name parameter");
    }
}
