package assignmentOne.controller.taxCalculatorFactory;

import assignmentOne.controller.TaxCalculator;
import assignmentOne.model.Item;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class TaxCalculatorRaw implements TaxCalculator {

    @Override
    public double calculateTax(Item item) {
        return (12.5 * (item.getPrice()) / 100);
    }
}
