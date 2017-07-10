package assignmentThree.controller;

import assignmentThree.exception.InvalidNodeException;
import assignmentThree.model.Node;
import assignmentThree.model.Tree;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class TreeHandler {

    private Node getNode(Tree tree, int id) throws InvalidNodeException {

        for(Node i : tree.nodeList){
            if(i.id == id){
                return i;
            }
        }
        throw new InvalidNodeException("Node Not Found");
    }
    public void addNode(Tree tree, int id, String name, HashMap info){
        Node node = new Node(id,name,info);

        tree.nodeList.add(node);

    }

    public void addDependency(Tree tree, int parentID, int childID)throws InvalidNodeException{
        Node parent = getNode(tree , parentID);
        Node child = getNode(tree , childID);
        tree.addDependency(parent,child);
    }

    public void removeNode(Tree tree, int id)throws InvalidNodeException{
        Node node = getNode(tree, id);
        tree.remove(node);
    }

    public void removeDependency(Tree tree, int parentID, int childID)throws InvalidNodeException{
        Node parent = getNode(tree , parentID);
        Node child = getNode(tree , childID);
        tree.removeDependency(parent,child);
    }

    public void getParents(Tree tree, int id)throws InvalidNodeException{
        Node node = getNode(tree,id);
        Set<Node> parents = tree.getParents(node);
        int count =1;
        for(Node i:parents){
            System.out.println("Parent of Node :"+node.Name+"  ( Node Name :"+i.Name+" Node ID :"+i.id+" )");
        }
    }

    public void getAncestors(Tree tree, int id) throws InvalidNodeException{
        Node node = getNode(tree,id);
        Set<Node> parents = tree.getAncestors(node);
        for(Node i:parents){
            System.out.println("Ancestors of Node :"+node.Name+"  ( "+i.Name+" ID :"+i.id+")");
        }
    }

    public void getChildren(Tree tree, int id)throws InvalidNodeException{
        Node node = getNode(tree,id);
        Set<Node> parents = tree.getChildren(node);
        for(Node i:parents){
            System.out.println("Child of Node :"+node.Name+"( Node Name :"+i.Name+" Node ID :"+i.id+" )");
        }
    }

    public void getDecedents(Tree tree, int id)throws InvalidNodeException{
        Node node = getNode(tree,id);
        Set<Node> parents = tree.getDescedents(node);
        for(Node i:parents){
            System.out.println("Decedents of Node :"+node.Name+" ( Node Name  :"+i.Name+"Node ID :"+i.id+")");
        }
    }

}
