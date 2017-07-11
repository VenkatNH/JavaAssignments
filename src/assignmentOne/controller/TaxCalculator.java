package assignmentOne.controller;

import assignmentOne.model.Item;
import assignmentOne.model.ItemType;

/**
 * Created by venkatdatta on 05/07/17.
 */
public interface TaxCalculator {

     double calculateTax(Item item);

}