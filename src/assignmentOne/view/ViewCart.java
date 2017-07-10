package assignmentOne.view;

import assignmentOne.model.Item;

import java.util.List;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class ViewCart {
    public void display(List<Item> items) {

        for (Item item : items) {
            System.out.println("=============================================================================================================================================================");
            System.out.printf("NAME  :  %-12s || QUANTITY :  %-12d || PRICE per item: %-12f    ||  SALES TAX per item: %-12f    ||  TOTAL PRICE : %-12f \n",item.getName(),item.getQuantity() ,item.getPrice(),
                    item.getTax(),(item.getTax() + item.getPrice()) * item.getQuantity());
        }
    }
}
