package assignmentThree.model;

import java.util.*;

/**
 * Created by venkatdatta on 05/07/17.
 */
public class Tree {
    public Set<Node> nodeList;
    private HashMap<Node,Set<Node>> nodeParent;

    public Tree(){
        nodeList = new HashSet<>();
        nodeParent = new HashMap<>();
    }
    private void checkNotNull(Node n){
        if(n == null){
            System.out.println("Node Value : NULL");
        }

    }

    public void addDependency(Node parent, Node child){
        if(checkForCycles(parent, child)) {
            System.out.println("CYCLE Exists");
            return ;
        }
        Set<Node> parents = getParents(child);
        if(parents == null)
            parents = new HashSet<>();
        parents.add(parent);
        nodeParent.put(child,parents);
    }

    public void remove(Node node){
        checkNotNull(node);
        for(Node child : getChildren(node)){
            removeDependency(node,child);
            remove(child);
        }
        nodeList.remove(node);
    }

    public void removeDependency(Node parent, Node child){
        Set<Node> temp;

        temp = getParents(child);
        Iterator<Node> iterator = temp.iterator();
        while(iterator.hasNext()){
            if(iterator.next().id == parent.id){
                iterator.remove();
            }
        }
    }

    private boolean checkForCycles(Node node1, Node node2){
        boolean cycle = false;
        Set<Node> parents = getParents(node1);

        if(parents == null)
            return false;

        for(Node parent : parents){
            if(node2.id == parent.id)
                return true;
            cycle = cycle || checkForCycles(parent,node2);
        }
        return cycle;
    }

    public Set<Node> getParents(Node n){


        return nodeParent.get(n);
    }

    public Set<Node> getChildren(Node node){

        Set<Node> children = new HashSet<>();

        for(Node n : nodeList){
            childs(n,children,node);
        }
    return children;
    }

    private void childs(Node node, Set<Node> list, Node main){
        if(node == null || getParents(node)==null)
            return;

        for(Node p : getParents(node)){
            if(main == null && p == null)
                list.add(node);
            else if(main != null && p != null && p.id == main.id){
                list.add(node);
            }
        }
    }

    public Set<Node> getAncestors(Node node){
        Set<Node> ancestors = new HashSet<>();
        if(node == null || getParents(node) == null)
            return new HashSet<>();

        for(Node n : getParents(node)){
            ancestors.add(n);
            ancestor(ancestors,n,node);
        }

        return ancestors;
    }
    private void ancestor(Set<Node> ancestors, Node n, Node node){
        if(n == null || getParents(n) == null)
            return;
        for(Node p : getParents(n)){
            ancestors.add(p);
            ancestor(ancestors,p,node);
        }
    }

    public Set<Node> getDescedents(Node node){
        Set<Node> descedent = new HashSet<>();

        for(Node n : getChildren(node)){
            descedent.add(n);
            descedents(descedent, n);
        }
        return descedent;
    }
    private void descedents(Set<Node> descdent, Node n){
        if(n == null || getChildren(n) == null){
            return;
        }
        for(Node c : getChildren(n)){
            descdent.add(c);
            descedents(descdent,c);
        }
    }


}
