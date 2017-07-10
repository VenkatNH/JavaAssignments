package assignmentFour.controller;

import assignmentFour.model.Item;
import assignmentFour.view.ViewCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by venkatdatta on 07/07/17.
 */
class Itinerary {

    private List<Item> itemList;
    private List<Item> cartBill;
    private boolean available = false;
    boolean readComplete = false;

    Itinerary() {
        itemList = new ArrayList<>();
        cartBill = new ArrayList<>();
    }

    synchronized void notifyReadComplete() {
        notifyAll();
    }

    /* Fetch Data from List and do the Tax Calculation */
    synchronized int processData(int counter) {

        if (!readComplete && !available) {
            try {
                System.out.println("Consumer Thread needs to wait!!");
                wait();
            } catch (InterruptedException e) {
                System.out.println("[ERROR] :" + e);
            }
        }
        if (!readComplete && counter == itemList.size()) {
            try {
                System.out.println("Consumer Thread needs to wait!!");
                wait();
            } catch (InterruptedException e) {
                System.out.println("[ERROR] :" + e);
            }
        }

        if (readComplete && counter == itemList.size()) {
            System.out.println("Consumer Thread processing complete!!");
            return -1;
        } else {
            Item item = itemList.get(counter);
            System.out.println("Consumer consumed Item :"+(counter+1));
            TaxCalculator calculator = new TaxCalculator(item);
            double taxAmount = calculator.calculateTax();
            item.setTax(taxAmount);
            setCartBill(item);
            counter++;

        }

        return counter;
    }

    /* Set the Item to the List */
    synchronized void setItemList(Item item) {
        System.out.println("Producer Thread has started ");
        itemList.add(item);
        System.out.println("Producer produced Item :"+itemList.size());
        available = true;
        System.out.println("Notify any waiting Consumer Thread");
        if (itemList.size() > 2)
            notify();
    }

    private void setCartBill(Item item) {
        cartBill.add(item);
    }

    /* Prints the Cart */
    void printCart() {
        ViewCart cart = new ViewCart();
        cart.display(cartBill);
    }
}
