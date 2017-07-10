package assignmentThree.view;


import assignmentThree.model.Tree;
import assignmentThree.controller.TreeHandler;
import assignmentThree.controller.GetUserInput;

import java.util.Scanner;

/**
 * Created by venkatdatta on 06/07/17.
 */

public class Menu {

    public void displayMenu(Tree tree) {
        int choice = 0;
        int temp[];
        Scanner in = new Scanner(System.in);
        TreeHandler handler = new TreeHandler();
        GetUserInput userInput = new GetUserInput();

        while (choice >= 0) {
            System.out.println("******  MENU  ******* \n" +
                    "1. Add Node \n" +
                    "2. Add Dependency\n" +
                    "3. Remove Node\n" +
                    "4. Remove Node Dependency\n" +
                    "5. Get Parents of Node \n" +
                    "6. Get Children of Node \n" +
                    "7. Get Ancestors of Node \n" +
                    "8. Get Decedents of Node \n" +
                    "9. Exit");
            System.out.println("Choice : ");
            choice = in.nextInt();

            in.nextLine();

            try {

                switch (choice) {
                    case MenuOptions.ADD_NODE:
                        handler.addNode(tree, userInput.getNodesID(), userInput.getNodeName(), userInput.getNodeInfo());
                        break;
                    case MenuOptions.ADD_DEPENDENCY:
                        temp = userInput.getNodesInput();
                        handler.addDependency(tree, temp[0], temp[1]);
                        break;
                    case MenuOptions.REMOVE_NODE:
                        handler.removeNode(tree, userInput.getNodesID());
                        break;
                    case MenuOptions.REMOVE_DEPENDENCY:
                        handler.removeDependency(tree, userInput.getNodesID(), userInput.getNodesID());
                        break;
                    case MenuOptions.GET_PARENTS:
                        handler.getParents(tree, userInput.getNodesID());
                        break;
                    case MenuOptions.GET_CHILDREN:
                        handler.getChildren(tree, userInput.getNodesID());
                        break;
                    case MenuOptions.GET_ANCESTORS:
                        handler.getAncestors(tree, userInput.getNodesID());
                        break;
                    case MenuOptions.GET_DECEDENTS:
                        handler.getDecedents(tree, userInput.getNodesID());
                        break;
                    case MenuOptions.EXIT:
                        choice = -1;
                        break;
                    default:
                        System.out.println("Invalid Entry");
                }
            } catch (Exception e) {
                System.out.println("[ERROR] " + e);
            }
        }

    }
}
