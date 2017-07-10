package assignmentFour.controller;

/**
 * Created by venkatdatta on 07/07/17.
 */
public class ThreadManager {
    private Itinerary items;

    public ThreadManager(){
        items = new Itinerary();
    }

    public void callDBThread(){

        DataReader dataThread = new DataReader(items);

        dataThread.start();

    }

    public void callComputeThread(){
        ComputeThread computeThread = new ComputeThread(items);

        computeThread.start();
    }



}
