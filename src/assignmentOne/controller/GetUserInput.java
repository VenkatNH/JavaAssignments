package assignmentOne.controller;

import assignmentOne.*;
import assignmentOne.model.Item;
import assignmentOne.model.ItemProperties;
import assignmentOne.model.Regex;

import java.util.Scanner;

/**
 * Created by venkatdatta on 05/07/17.
 */
public class GetUserInput {

    /* Gets the input from User Console */
    public Item getInput()throws InvalidInputException {

        Scanner in = new Scanner(System.in);
        String input ;
        String data[];
        ValidateInput validate = new ValidateInput();
        Item item = new Item();
        System.out.println("Enter the Input :");
        System.out.println("Hint : \n--name <Name of Item> \n" +
                                     "--quantity <Quantity> \n " +
                                     "--price <Price Of Item> \n" +
                                    "--type <Type> ");

        for(int i = 0 ; i < 7 ; i+=2){
            input = in.nextLine();
            data = input.split(Regex.WHITESPACE);

            if (i == 0 && !data[0].equalsIgnoreCase(ItemProperties.NAME))
                throw new InvalidInputException("Expecting --name parameter");

            if (checkProperty(data[0]) && data.length > 1) {

                if (validate.validateName(data)) {

                    if(data.length > 2){
                        String temp="";

                        for(int x=1; x<data.length;x++)
                            temp +=" "+data[x];

                        item.setName(temp);

                    }else
                        item.setName(data[1]);

                } else if (validate.validateItemType(data)) {

                    item.setType(data[1]);

                } else if (validate.validateQuantity(data)) {

                    item.setQuantity(Integer.parseInt(data[1]));

                } else if (validate.validatePrice(data)) {

                    item.setPrice(Double.parseDouble(data[1]));

                }
            } else {

                throw new InvalidInputException("Invalid Input Format");
            }
        }

        return item;
    }

    /* Function handles setting the Properties of the Item */
    public Item setItemProperties(String args[]) throws InvalidInputException{
        Item item = new Item();
        String data[] = new String[2];
        ValidateInput validateInput = new ValidateInput();
        for (int i = 0; i < args.length; i += 2) {

            data[0] = args[i];
            data[1] = args[i+1];

            if (validateInput.validateName(data)) {

                item.setName(args[i + 1]);

            } else if (validateInput.validatePrice(data)) {

                item.setPrice(Double.parseDouble(args[i + 1]));

            } else if (validateInput.validateQuantity(data)) {

                item.setQuantity(Integer.parseInt(args[i + 1]));

            } else if (validateInput.validateItemType(data)) {

                   item.setType(args[i + 1]);
            }
        }
        return item;
    }

    /* Check for a valid Item Property */
    private boolean checkProperty(String val) {
        if (val.equalsIgnoreCase(ItemProperties.NAME)
                || val.equalsIgnoreCase(ItemProperties.PRICE)
                || val.equalsIgnoreCase(ItemProperties.QUANTITY)
                || val.equalsIgnoreCase(ItemProperties.TYPE))
            return true;
        else
            return false;
    }

}
