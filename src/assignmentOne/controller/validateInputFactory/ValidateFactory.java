package assignmentOne.controller.validateInputFactory;

import assignmentOne.InvalidInputException;
import assignmentOne.controller.ValidateInput;
import assignmentOne.model.ItemProperties;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class ValidateFactory {

    public ValidateInput validateProperty(String args[]) throws InvalidInputException{
        if (args == null || args.length < 2) {
            throw new InvalidInputException("Missing Arguments");
        }
        switch (args[0]) {
            case ItemProperties.NAME:
                return new ValidateName();
            case ItemProperties.PRICE:
                return new ValidatePrice();
            case ItemProperties.QUANTITY:
                return new ValidateQuantity();
            default:
                return new ValidateItemType();
        }
    }
}
