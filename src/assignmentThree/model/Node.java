package assignmentThree.model;

import java.util.HashMap;

/**
 * Created by venkatdatta on 05/07/17.
 */
public class Node {
    public int id;
    public String Name;
    public HashMap info;
    public Node(int a, String str, HashMap data){
        id = a;
        Name  = str;
        info = data;
    }
}
