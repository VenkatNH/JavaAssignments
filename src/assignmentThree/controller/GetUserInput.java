package assignmentThree.controller;

import assignmentThree.exception.InvalidInputException;
import assignmentThree.model.Regex;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class GetUserInput {

    public int [] getNodesInput() throws InvalidInputException {
        Scanner in = new Scanner(System.in);
        ValidateData validate = new ValidateData();
        String data1,data2;
        int returnData[] = new int[2];
        System.out.println("Enter the Parent Node ID :");
        data1 = in.nextLine();
        if(!validate.validateInt(data1)){
            throw new InvalidInputException("Parent Node ID : Invalid Value");
        }
        System.out.println("Enter the Child Node ID :");
        data2 = in.nextLine();
        if(!validate.validateInt(data2)){
            throw new InvalidInputException("Child Node ID : Invalid Value");
        }
        returnData[0] = Integer.parseInt(data1);
        returnData[1] = Integer.parseInt(data2);

        return returnData;


    }


    public int getNodesID() throws InvalidInputException{
        Scanner in = new Scanner(System.in);
        ValidateData validate = new ValidateData();
        String data;

        System.out.println("Enter the Node ID :");
        data = in.nextLine();
        if(!validate.validateInt(data))
            throw new InvalidInputException("Node ID : Invalid Value");
        return Integer.parseInt(data);
    }


    public String getNodeName() throws InvalidInputException{
        Scanner in = new Scanner(System.in);
        ValidateData validate = new ValidateData();
        String data;
        System.out.println("Enter the Node Name :");
        data = in.nextLine();
        if(!validate.validateString(data))
            throw new InvalidInputException("Node ID : Invalid Value");
        return data;

    }


    public HashMap getNodeInfo() throws InvalidInputException{
        Scanner in = new Scanner(System.in);
        HashMap data = new HashMap();
        String temp;
        System.out.println("Enter the Node Info  : (Hint : <key> <value>)");
        while ((temp = in.nextLine()) != null && !temp.equals("")) {
            String readData[] = temp.split(Regex.WHITESPACE);
            data.put(readData[0], readData[1]);
        }

        return data;
    }

}
