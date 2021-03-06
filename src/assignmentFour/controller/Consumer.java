package assignmentFour.controller;

/**
 * Created by venkatdatta on 07/07/17.
 */
public class Consumer extends Thread {

    private Itinerary itinerary;

    Consumer(Itinerary items) {
        itinerary = items;
    }

    public void run() {
        int counter = 0;
        while (counter != -1) {
            counter = itinerary.processData(counter);
        }
        itinerary.printCart();
    }
}
