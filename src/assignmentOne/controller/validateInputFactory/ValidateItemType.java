package assignmentOne.controller.validateInputFactory;

import assignmentOne.InvalidInputException;
import assignmentOne.controller.ValidateInput;
import assignmentOne.model.ItemProperties;
import assignmentOne.model.ItemType;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class ValidateItemType implements ValidateInput {

    @Override
    public int validate(String data[]) throws InvalidInputException {
        if (data[0].equalsIgnoreCase(ItemProperties.TYPE)) {
            if (data[1].equals(ItemType.RAW) || data[1].equals(ItemType.MANUFACTURED) || data[1].equals(ItemType.IMPORTED)) {
                return 4;
            } else {
                throw new InvalidInputException("--type Invalid Value ");
            }
        }
        return -1;
    }
}
