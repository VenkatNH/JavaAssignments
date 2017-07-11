package assignmentOne.controller.taxCalculatorFactory;

import assignmentOne.controller.TaxCalculator;
import assignmentOne.model.Item;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class TaxCalculatorModified implements TaxCalculator {

    @Override
    public double calculateTax(Item item) {
        double price = item.getPrice();

        return 0.125 * (price) + ( 0.02 * (price + ( 0.125 * price)));

    }
}
