package assignmentFour.controller;

import assignmentFour.model.Item;
import assignmentFour.view.ViewCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by venkatdatta on 07/07/17.
 */
class Itinerary {

    private final List<Item> sharedQueue;
    private List<Item> cartBill;
    private final int  SIZE = 3;
    boolean readComplete = false;

    Itinerary() {
        sharedQueue = new ArrayList<>(3);
        cartBill = new ArrayList<>();
    }

    void notifyReadComplete() {
        System.out.println("<Produce> Done Reading the Database .... \n");
        synchronized (sharedQueue) {
            sharedQueue.notify();
        }
    }

    /* Fetch Data from List and do the Tax Calculation */
    int processData(int counter) {

        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            if(readComplete && sharedQueue.size()==0) {
                return -1;
            }

            while (sharedQueue.size() == 0) {
                synchronized (sharedQueue) {
                    try {
                        System.out.println("<Consumer> Queue is empty, consumerThread is waiting ...  \n");
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("[ERROR] :" + e);
                    }

                }
            }

            synchronized (sharedQueue) {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Item item = sharedQueue.get(0);
                sharedQueue.remove(0);
                System.out.println("<Consumer> Consumer consumed Item :" + (counter + 1) + " Size of queue :" + sharedQueue.size()+" \n");
                TaxCalculator calculator = new TaxCalculator(item);
                double taxAmount = calculator.calculateTax();
                item.setTax(taxAmount);
                setCartBill(item);
                counter++;
                sharedQueue.notify();
            }

        return counter;
    }

    /* Set the Item to the List */
    void setItemList(Item item) {

            while (sharedQueue.size() == SIZE) {
                synchronized (sharedQueue) {
                    System.out.println("<Producer> Queue is Full . Producer Needs to wait \n");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("[ERROR] : " + e);
                    }
                }
            }

            synchronized (sharedQueue) {
                System.out.println("<Producer> Producer Thread has started ");
                sharedQueue.add(item);
                System.out.println("<Producer> Producer produced Item!! Size of Queue : "+sharedQueue.size());
                System.out.println("<Producer> Notify any waiting Consumer Thread \n");
                sharedQueue.notify();
            }
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
