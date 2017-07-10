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
                        "8. Get Decedents of Node \n"+
                        "9. Exit");
                System.out.println("Choice : ");
                choice = in.nextInt();

                in.nextLine();

                try {

                    switch (choice) {
                        case 1:
                            handler.addNode(tree, userInput.getNodesID(), userInput.getNodeName(), userInput.getNodeInfo());
                            break;
                        case 2:
                            temp = userInput.getNodesInput();
                            handler.addDependency(tree, temp[0], temp[1]);
                            break;
                        case 3:
                            handler.removeNode(tree, userInput.getNodesID());
                            break;
                        case 4:
                            handler.removeDependency(tree, userInput.getNodesID(), userInput.getNodesID());
                            break;
                        case 5:
                            handler.getParents(tree, userInput.getNodesID());
                            break;
                        case 6:
                            handler.getChildren(tree, userInput.getNodesID());
                            break;
                        case 7:
                            handler.getAncestors(tree, userInput.getNodesID());
                            break;
                        case 8:
                            handler.getDecedents(tree, userInput.getNodesID());
                            break;
                        case 9:
                            choice = -1;
                            break;
                        default:
                            System.out.println("Invalid Entry");
                    }
                }catch(Exception e){
                    System.out.println("[ERROR] "+e);
                }
            }

    }
}
