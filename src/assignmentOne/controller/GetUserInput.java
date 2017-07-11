package assignmentOne.controller;

import assignmentOne.*;
import assignmentOne.controller.validateInputFactory.ValidateFactory;
import assignmentOne.model.Item;
import assignmentOne.model.ItemProperties;
import assignmentOne.model.Regex;
import assignmentOne.model.Validate;

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
        ValidateFactory validateFactory = new ValidateFactory();
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

            switch (validateFactory.validateProperty(data).validate(data)){
                case Validate.NAME:
                    if(data.length > 2){
                        String temp="";

                        for(int x=1; x<data.length;x++)
                            temp +=" "+data[x];

                        item.setName(temp);

                    }else
                        item.setName(data[1]);
                    break;
                case Validate.QUANTITY:
                    item.setQuantity(Integer.parseInt(data[1]));
                    break;
                case Validate.PRICE:
                    item.setPrice(Double.parseDouble(data[1]));
                    break;
                case Validate.TYPE:
                    item.setType(data[1]);
                    break;
                default:
                    System.out.println("ERROR");
            }

        }

        return item;
    }

    /* Function handles setting the Properties of the Item */
    public Item setItemProperties(String args[]) throws InvalidInputException{
        Item item = new Item();
        String data[] = new String[2];
        ValidateFactory validateFactory = new ValidateFactory();
        for (int i = 0; i < args.length; i += 2) {

            data[0] = args[i];
            data[1] = args[i+1];

            switch (validateFactory.validateProperty(data).validate(data)){
                case Validate.NAME:
                    if(data.length > 2){
                        String temp="";

                        for(int x=1; x<data.length;x++)
                            temp +=" "+data[x];

                        item.setName(temp);

                    }else
                        item.setName(data[1]);
                    break;
                case Validate.QUANTITY:
                    item.setQuantity(Integer.parseInt(data[1]));
                    break;
                case Validate.PRICE:
                    item.setPrice(Double.parseDouble(data[1]));
                    break;
                case Validate.TYPE:
                    item.setType(data[1]);
                    break;
                default:
                    System.out.println("ERROR");
            }
        }
        return item;
    }

}
