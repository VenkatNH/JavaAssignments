package assignmentTwo.view;

import assignmentTwo.controller.SaveUser;
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
        SaveUser userDetails = new SaveUser();


        try {
            while (choice >= 0) {
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
                    case 1:
                        addUser.addUserDetails(students.studentDB);
                        break;
                    case 2:
                        displayUser.displayUserDetails(students.studentDB);

                        break;
                    case 3:
                        userDetails.deleteUserDetails(students.studentDB);
                        break;
                    case 4:
                        userDetails.saveUserDetails(students);
                        break;
                    case 5:
                        System.out.println("Save the changes (y/n) :");
                        if (in.next().charAt(0) == 'y')
                            userDetails.saveUserDetails(students);
                        choice = -1;
                        break;
                }


            }
        } catch (Exception e) {
            System.out.println("[ERROR] " + e);
        }
    }
}
