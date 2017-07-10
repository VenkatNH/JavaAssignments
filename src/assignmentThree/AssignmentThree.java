package assignmentThree;

import assignmentThree.model.Tree;
import assignmentThree.view.Menu;

/**
 * Created by venkatdatta on 05/07/17.
 */
public class AssignmentThree {


    public static void main(String args[]){
        Tree testTree = new Tree();
        Menu menu = new Menu();
        menu.displayMenu(testTree);
    }

}
