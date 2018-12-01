/*
 * filename: BinarySearchTree.java
 * author: roland carter
 * date: 2018-11-30
 * purpose: BinarySearchTree class creates a generic binary search tree
*/

package sortinggui;

// import libraries
import java.util.*;

// being generic class BinarySearchTree
public class BinarySearchTree<T extends Comparable<T>> {
    
    private StringBuilder resultString = new StringBuilder();
    private Node<T> root;

    // BinarySearchTree initializes tree
    public BinarySearchTree() {
        root = null;
        resultString.setLength(0);
    }
    
    
    // insert method uses recusiveInsertion() helper method to insert
    // values into binary search tree
    public void insert(T value){
        root = recusiveInsertion(root, value);
    }
    
    
    // recusiveInsertion method inserts items into binary search tree
    private Node<T> recusiveInsertion(Node<T> currentNode, T value){
        // if tree is empty, return the current value as the root
        if(currentNode == null) {
            return new Node(value);
        }
        
        // insert based on compareTo method
        if(value.compareTo(currentNode.getValue()) <= 0){
            currentNode.setLeft(recusiveInsertion(currentNode.getLeft(), value));
        }
        else if (value.compareTo(currentNode.getValue()) > 0) {
            currentNode.setRight(recusiveInsertion(currentNode.getRight(), value));
        }
        
        return currentNode;
    }
    
    
    // inOrder method traverses a binary search tree and appends the values
    // in order to resultString
    private void inOrder(Node root){
        if(root.getValue() != null){
            if(root.getLeft()!= null) {
                inOrder(root.getLeft());
            }
            // append root value to resultString string
            resultString.append((root.getValue()).toString()).append(" ");
            
            if(root.getRight()!= null) {
                inOrder(root.getRight());
            }
        }
    }
    
    
    // getAscendingOrder method returns in order traversal in ascending order
    public String getAscendingOrder(){
        inOrder(root);
        return resultString.toString();
    }
    
    // getDescendingOrder method returns in order traversal in ascending order
    public String getDescendingOrder(){
        // create new StringBulder to hold desc output
        StringBuilder descResultsString = new StringBuilder();
        inOrder(root);
        String inOrder = resultString.toString();
        String[] inOrderArray = inOrder.split(" ");
        
        for(int i = inOrderArray.length - 1; i >= 0; i--){
            descResultsString.append(inOrderArray[i]).append(" ");
        }
        
        return descResultsString.toString();
    }

} // end BinarySearchTree
