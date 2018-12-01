/*
 * filename: Node.java
 * author: roland carter
 * date: 2018-11-30
 * purpose: Node defines a set of parameters for generic Nodes within BinarySearchTree
*/

package sortinggui;

// begin generic class Node
public class Node<T extends Comparable<T>> {
    private T value;
    private Node right;
    private Node left;
    
    
    // constructor
    Node(T value){
        this.value = value;
        right = null;
        left = null;
    }
    
    
    // value get method
    public T getValue() {
        return value;
    }
    
    
    // value set method
    public void setValue(T value) {
        this.value = value;
    }
    
    // get each sides
    public Node getRight() {
        return right;
    }
    
    public Node getLeft() {
        return left;
    }
    
    
    // set each side
    public void setRight(Node right) {
        this.right = right;
    }
    
    public void setLeft(Node left) {
        this.left = left;
    }
    
}
