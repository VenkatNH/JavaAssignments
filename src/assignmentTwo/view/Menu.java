package assignmentTwo.view;

import assignmentTwo.controller.UserDetails;
import assignmentTwo.model.MenuProperties;
import assignmentTwo.model.StudentDB;
import assignmentTwo.controller.AddUser;
import assignmentTwo.view.DisplayUser;

import java.util.Scanner;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class Menu {


    /* Function Displays the Menu Details */
    public void displayMenu(StudentDB students) {
        int choice = 0;
        Scanner in = new Scanner(System.in);
        AddUser addUser = new AddUser();
        DisplayUser displayUser = new DisplayUser();
        UserDetails userDetails = new UserDetails();
        boolean recordAdded = false;


        while (choice >= 0) {
            try {
                System.out.println("******  MENU  ******* \n" +
                        "1. Add User details.\n" +
                        "2. Display User details.\n" +
                        "3. Delete User details\n" +
                        "4. Save User details.\n" +
                        "5. Exit\n");
                System.out.println("Choice : ");
                choice = in.nextInt();

                in.nextLine();

                switch (choice) {
                    case MenuProperties.ADD_USER:
                        addUser.addUserDetails(students.studentDB);
                        recordAdded = true;
                        break;
                    case MenuProperties.DISPLAY_USER:
                        displayUser.displayUserDetails(students.studentDB);

                        break;
                    case MenuProperties.DELETE_USER:
                        userDetails.deleteUserDetails(students.studentDB);
                        break;
                    case MenuProperties.SAVE_USER:
                        userDetails.saveUserDetails(students);
                        break;
                    case MenuProperties.EXIT:
                        if (recordAdded) {
                            System.out.println("Save the changes (y/n) :");
                            if (in.next().equalsIgnoreCase("y"))
                                userDetails.saveUserDetails(students);
                        }
                        choice = -1;
                        break;
                }


            }catch (Exception e) {
                System.out.println("[ERROR] " + e);
            }
        }
    }
}
