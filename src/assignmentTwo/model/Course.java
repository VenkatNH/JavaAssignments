package assignmentTwo.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by venkatdatta on 05/07/17.
 */
public class Course implements Serializable{
    private String courses[];
    public void setCourses(String val[]){
        if(val.length < 4)
            System.out.println("ERROR");
        courses = val.clone();

    }
    public String getCourses(){
        return Arrays.toString(courses);
    }
}
