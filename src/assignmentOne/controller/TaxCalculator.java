package assignmentOne.controller;

import assignmentOne.model.Item;
import assignmentOne.model.ItemType;

/**
 * Created by venkatdatta on 05/07/17.
 */
public class TaxCalculator {

    private Item item;

    public TaxCalculator(Item item) {
        this.item = item;
    }

    /* Function determines the Type of the Item and calculates Tax accordingly */
    public double calculateTax(){
        double taxAmount = 0.0d;
        switch (item.getType() == null ? "" : item.getType()) {
            case ItemType.RAW:
                taxAmount = calculateRawTax(item);
                break;
            case ItemType.MANUFACTURED:
                taxAmount = calculateManufacturedTax(item);
                break;
            case ItemType.IMPORTED:
                taxAmount = calculateImportedTax(item);
                break;
        }
        return taxAmount;
    }

    /* Function calculates Tax for Item Type Raw */
    private double calculateRawTax(Item itinerary) {
        return (12.5 * (itinerary.getPrice()) / 100);
    }

    /* Function Calculates Tax for Item Type Manufactured */
    private double calculateManufacturedTax(Item itinerary) {
        double price = itinerary.getPrice();

        return 0.125 * (price) + ( 0.02 * (price + ( 0.125 * price)));

    }

    /* Function Calculates Tax for Item Type Imported */
    private double calculateImportedTax(Item itinerary) {
        double taxAmount;

        double price = itinerary.getPrice();
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