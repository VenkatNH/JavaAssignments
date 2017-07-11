package assignmentOne.controller.taxCalculatorFactory;

import assignmentOne.controller.TaxCalculator;
import assignmentOne.model.Item;

/**
 * Created by venkatdatta on 11/07/17.
 */
public class TaxCalculatorImported implements TaxCalculator {

    @Override
    public double calculateTax(Item item) {
        double taxAmount;

        double price = item.getPrice();
        double impCost = 0.1 * price;

        if(impCost+price < 100)
            taxAmount = impCost + 5;
        else if(impCost + price > 100 && impCost + price < 200)
            taxAmount = impCost + 10;
        else
            taxAmount = impCost + (0.05 * price);

        return taxAmount;
    }
}
