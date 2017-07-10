package assignmentFour;

import assignmentFour.controller.ThreadManager;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class AssignmentFour
{
    public static void main(String args[]){
        ThreadManager manager = new ThreadManager();
        manager.callDBThread();
        manager.callComputeThread();


    }
}
