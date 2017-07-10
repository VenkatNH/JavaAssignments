package assignmentFour.view;

import assignmentFour.model.Item;

import java.util.List;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class ViewCart {
    public void display(List<Item> items) {

        System.out.println("=====================================================================================================");
        System.out.println(" Name         Quantity      Price per Item     Sales Tax per Item      Total Price       ");
        for (Item item : items) {
            System.out.println("=====================================================================================================");
            System.out.printf("%-12s   %-12d   %-12f      %-12f            %-12f \n",item.getName(),item.getQuantity() ,item.getPrice(),
                    item.getTax(),(item.getTax() + item.getPrice()) * item.getQuantity());
        }
    }
}
