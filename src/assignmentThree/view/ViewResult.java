package assignmentThree.view;

import assignmentThree.model.Node;

import java.util.List;
import java.util.Set;

/**
 * Created by venkatdatta on 10/07/17.
 */
public class ViewResult {
    /* Display Function for viewing the Node Information */
    public void display(Set<Node> nodes) {

        System.out.println("========================================================================================");
        System.out.println(" Node ID       Node Name      Node Info");
        for (Node node : nodes) {
            System.out.println("========================================================================================");
            System.out.printf(" %-12d   %-12s   %-12s  \n",node.id,node.Name,node.info.toString());
        }
        System.out.println("========================================================================================");
    }
}
