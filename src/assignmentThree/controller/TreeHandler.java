package assignmentThree.controller;

import assignmentThree.exception.InvalidNodeException;
import assignmentThree.model.Node;
import assignmentThree.model.Tree;
import assignmentThree.view.ViewResult;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by venkatdatta on 06/07/17.
 */
public class TreeHandler {
    ViewResult viewData;
    public TreeHandler(){
        viewData = new ViewResult();
    }

    private Node getNode(Tree tree, int id) throws InvalidNodeException {

        for(Node i : tree.nodeList){
            if(i.id == id){
                return i;
            }
        }
        throw new InvalidNodeException("Node Not Found");
    }
    public void addNode(Tree tree, int id, String name, HashMap info) throws InvalidNodeException{
        Node node = new Node(id,name,info);
        for(Node n : tree.nodeList){
            if(n.id == node.id){
                throw new InvalidNodeException("Node Already  Exists");
            }
        }
        tree.nodeList.add(node);

        System.out.println("Node Successfully Added");
    }

    public void addDependency(Tree tree, int parentID, int childID)throws InvalidNodeException{
        Node parent = getNode(tree , parentID);
        Node child = getNode(tree , childID);
        tree.addDependency(parent,child);

        System.out.println("Added Dependency Successfully");
    }

    public void removeNode(Tree tree, int id)throws InvalidNodeException{
        Node node = getNode(tree, id);
        tree.remove(node);

        System.out.println("Removed Node Successfully");
    }

    public void removeDependency(Tree tree, int parentID, int childID)throws InvalidNodeException{
        Node parent = getNode(tree , parentID);
        Node child = getNode(tree , childID);
        tree.removeDependency(parent,child);

        System.out.println("Removed Dependency Successfully");
    }

    public void getParents(Tree tree, int id)throws InvalidNodeException{
        Node node = getNode(tree,id);
        Set<Node> parents = tree.getParents(node);
        if(parents.size() == 0){
            System.out.println("No Parent Node");
        }
        this.viewData.display(parents);
    }

    public void getAncestors(Tree tree, int id) throws InvalidNodeException{
        Node node = getNode(tree,id);
        Set<Node> parents = tree.getAncestors(node);
        if(parents.size() == 0){
            System.out.println("No Ancestors of Node");
        }
        this.viewData.display(parents);
    }

    public void getChildren(Tree tree, int id)throws InvalidNodeException{
        Node node = getNode(tree,id);
        Set<Node> children = tree.getChildren(node);
        if(children.size() == 0){
            System.out.println("Children not found");
        }
        this.viewData.display(children);
    }

    public void getDecedents(Tree tree, int id)throws InvalidNodeException{
        Node node = getNode(tree,id);
        Set<Node> children = tree.getDescedents(node);
        if(children.size() == 0){
            System.out.println("Descedents not found");
        }
        this.viewData.display(children);

    }

}
