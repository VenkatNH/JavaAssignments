package assignmentOne.controller.taxCalculatorFactory;

import assignmentOne.controller.TaxCalculator;
import assignmentOne.model.ItemType;
import assignmentOne.model.Item;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class TaxCalculatorFactory {

    public TaxCalculator calculateTax(Item item){
        switch (item.getType() == null ? "" : item.getType()) {
            case ItemType.RAW:
                return new TaxCalculatorRaw();
            case ItemType.MANUFACTURED:
                return new TaxCalculatorModified();
            case ItemType.IMPORTED:
                return new TaxCalculatorImported();
            default:
                return null;
        }

    }
}
