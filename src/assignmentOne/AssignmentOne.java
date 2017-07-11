package assignmentOne;

import assignmentOne.controller.*;
import assignmentOne.controller.taxCalculatorFactory.TaxCalculatorFactory;
import assignmentOne.controller.validateInputFactory.ValidateFactory;
import assignmentOne.model.*;
import assignmentOne.view.ViewCart;

import java.util.*;

public class AssignmentOne {

    public static void main(String args[]) {

        Scanner in;
        String userEntry;
        List<Item> items = new ArrayList<>();
        in = new Scanner(System.in);

        AssignmentOne testObj = new AssignmentOne();
        /* Try&Catch for handling the arguments passed in Command Line */
        try {
            testObj.handleInput(args, items,false);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e);
        }


        while (true) {
            System.out.println("Do you want to enter the details of any other item (y/n) :");
            userEntry = in.next();
            if (userEntry.equalsIgnoreCase("y")) {
				/* Try & Catch for Handling the input given in user console */
                try {
                    testObj.handleInput(args,items,true);
                } catch (Exception e) {
                    System.out.println("[ERROR] " + e);
                }
            } else if(userEntry.equalsIgnoreCase("n")){
                break;
            }else{
                System.out.println("Invalid Entry");
            }
        }
    }

    /* Handle User Inputs */
    private void handleInput(String args[], List<Item> items,boolean parse) throws InvalidInputException {
        Item item;
        ViewCart cart = new ViewCart();
        GetUserInput getUserInput = new GetUserInput();

        if(parse){
            item = getUserInput.getInput();
        }else{
            item = getUserInput.setItemProperties(args);
        }
        TaxCalculator calculator = new TaxCalculatorFactory().calculateTax(item);

        item.setTax(calculator.calculateTax(item));
        items.add(item);
        cart.display(items);
    }
}
