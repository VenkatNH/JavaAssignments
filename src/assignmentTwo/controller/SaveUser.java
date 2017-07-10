package assignmentTwo.controller;

import assignmentTwo.exceptions.InvalidInputException;
import assignmentTwo.model.Regex;
import assignmentTwo.model.Student;
import assignmentTwo.model.StudentDB;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class SaveUser {

    private static final String USERFILE = "studentDB.txt";


    /* Delete the Record Mentioned By the User */
    public void deleteUserDetails(TreeSet<Student> studentDB) throws InvalidInputException {
        int rollNumber ;
        boolean rollFound = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Roll Number : ");
        String data = in.nextLine();
        if(data != null && Pattern.matches(Regex.INT, data)){
            rollNumber = Integer.parseInt(data);
        }else{
            throw new InvalidInputException("RollNum : Invalid Value");
        }
        Iterator<Student> itr = studentDB.iterator();
        while(itr.hasNext()){
            Student student = itr.next();
            if(student.getRollNum() == rollNumber){
                itr.remove();
                rollFound = true;
            }
        }
        if(rollFound){
            System.out.println("Student Record Deleted");
        }else{
            System.out.println("Student Record Not Found");
        }
    }

    /* Save User Details into File */
    public void saveUserDetails(StudentDB students){

        try {
            FileOutputStream file = new FileOutputStream(new File(SaveUser.USERFILE));
            ObjectOutputStream obj = new ObjectOutputStream(file);
            obj.writeObject(students);
            obj.close();
            file.close();
        } catch (IOException e){
            System.out.println("[ERROR] :"+e);
        }
        System.out.println(" Changes Saved Successfully!!");
    }


    /*Load User Details From the File */
    public StudentDB loadUserDetails(){
        StudentDB database = null ;
        try {
            FileInputStream file = new FileInputStream(new File(SaveUser.USERFILE));
            ObjectInputStream obj = new ObjectInputStream(file);
            database = (StudentDB) obj.readObject();
            obj.close();
            file.close();
        }catch (FileNotFoundException e){
            System.out.println("File Not Found :"+e);
        }catch (IOException e){
            System.out.println(" [ERROR] : "+e);
        }catch (ClassNotFoundException e){
            System.out.println("[ERROR] :"+e);
        }


        return database;
    }
}
