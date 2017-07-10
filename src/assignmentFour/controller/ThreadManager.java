package assignmentFour.controller;

/**
 * Created by venkatdatta on 07/07/17.
 */
public class ThreadManager {

    private Itinerary items;

    public ThreadManager(){
        items = new Itinerary();
    }

    public void callProducerThread(){
        Producer dataThread = new Producer(items);
        dataThread.start();
    }

    public void callConsumerThread(){
        Consumer consumer = new Consumer(items);
        consumer.start();
    }



}
