package assignmentOne;

import assignmentOne.controller.GetUserInput;
import assignmentOne.controller.TaxCalculator;
import assignmentOne.controller.ValidateInput;
import assignmentOne.model.*;
import assignmentOne.view.ViewCart;

import java.util.*;

public class AssignmentOne {

    public static void main(String args[]) {

        Scanner in;
        char userEntry;
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
            userEntry = in.next().charAt(0);
            if (userEntry == 'y') {
				/* Try & Catch for Handling the input given in user console */
                try {
                    testObj.handleInput(args,items,true);
                } catch (Exception e) {
                    System.out.println("[ERROR] " + e);
                }
            } else {
                break;
            }
        }
    }

    /* Handle User Inputs */
    private void handleInput(String args[], List<Item> items,boolean parse) throws InvalidInputException {
        Item item;
        ViewCart cart = new ViewCart();
        ValidateInput validateInput = new ValidateInput();
        GetUserInput getUserInput = new GetUserInput();

        if(parse){
            item = getUserInput.getInput();
        }else{
            item = getUserInput.setItemProperties(args);
        }
        TaxCalculator calculateTax = new TaxCalculator(item);

        validateInput.validateArgument(args);

        item.setTax(calculateTax.calculateTax());
        items.add(item);
        cart.display(items);
    }
}
