package assignmentOne.controller.validateInputFactory;

import assignmentOne.InvalidInputException;
import assignmentOne.controller.ValidateInput;
import assignmentOne.model.ItemProperties;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class ValidateName implements ValidateInput {

    @Override
    public int validate(String data[]) throws InvalidInputException {
        if(data[0].equalsIgnoreCase(ItemProperties.NAME)){
            if (!data[1].equals("") && data[1] != null) {
                return 1;
            } else {
                throw new InvalidInputException(" --name Invalid Value");
            }
        }
        return -1;
    }
}
