package assignmentTwo.model;

import assignmentTwo.model.Course;

import java.io.Serializable;

/**
 * Created by venkatdatta on 05/07/17.
 */
public class Student implements Serializable{
    private int age;
    private String fullName;
    private String address;
    private int rollNum;
    public Course course;


    public Student(){
        course = new Course();
    }

    public int getAge(){
        return age;
    }

    public String getFullName(){
        return fullName;
    }

    public String getAddress(){
        return address;
    }

    public int getRollNum(){
        return rollNum;
    }

    public void setAge(int val){
        age = val;
    }

    public void setFullName(String val){
        fullName = val;
    }

    public void setAddress(String val){
        address = val;
    }

    public void setRollNum(String val){
        rollNum = Integer.parseInt(val);
    }

}