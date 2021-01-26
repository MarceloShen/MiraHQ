// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

package BSTImplementation;

import java.util.*;

/**
 * We all worked together to solve and debug all the problems and issues along the way
 * 
 * @author Marcelo Shen, Ashley Mead, Brandon Yi, Eashver Elango
 * 
 */
public class SearchTree2<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree2() {
        overallRoot = new SearchTreeNode<>(null);

    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        if (overallRoot.data == null) {
            overallRoot.data = value;
        }
        add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private void add(SearchTreeNode<E> root, E value) {

        // If the value is smaller than the current node, go to the left node 
        if(value.compareTo(root.data) < 0) {
            if (root.left == null) {
                root.left = new SearchTreeNode<E>(value);
            } else {
                add(root.left, value);
            }
        }
        // If the value is greater than the current node, go to the right node
        else if(value.compareTo(root.data) > 0) {
            if (root.right == null) {
                root.right = new SearchTreeNode<E>(value);
            } else {
                add(root.right, value);
            }
        }
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        if (overallRoot.data == null) {
            return false;
        }
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if(root == null) {
            return false;
        } else if(root.data == value){
            return true;
        } else{
            return contains(root.left, value) || contains(root.right, value);
        }
    }
    
    // post: value removed from tree so as to preserve binary search tree
    public void remove(E value) {
        if (overallRoot.data == null) {
            return;
        } else if (overallRoot.data.equals(value)) {
            overallRoot.data = null;
            return;
        }
        remove(overallRoot, value);
    }
    
    
 // post: value removed to tree so as to preserve binary search tree
    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return null;
        } else if (value.compareTo(root.data) < 0) {
            root.left = remove(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = remove(root.right, value);
        } else {
            if (root.right == null) { 
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else { 
                root.data = findSmallest(root.right);
                root.right = remove(root.right, root.data);
            }
        }
        return root;
    }
    
    // post: return the smallest value in the binary search tree  
    private E findSmallest(SearchTreeNode<E> root) {
        // go left until you can't go left anymore
        if(root.left != null) {
            return findSmallest(root.left);
        }
        
        return root.data;
    }

    // a function for fun...
    public void printTreeShape() {
        if (overallRoot.data == null) {
            return;
        }
        LinkedList<SearchTreeNode<E>> ll = new LinkedList<>();
        LinkedList<SearchTreeNode<E>> swap = new LinkedList<>();
        ll.add(overallRoot);
        while(!ll.isEmpty()){
            SearchTreeNode<E> cur = ll.pop();
            if(cur != null){
                System.out.print(cur.data + " ");
                swap.add(cur.left); 
                swap.add(cur.right);
            }
            if(ll.isEmpty()){
                System.out.println();
                ll.addAll(swap);
                swap.clear();
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print(){
        if (overallRoot.data == null) {
            return;
        }
        printInOrder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInOrder(SearchTreeNode<E> root) {
        // go left until you can't go left anymore
        if(root.left != null) {
            printInOrder(root.left);
        }

        System.out.print(root.data + "\n");
        
        if(root.right != null) {
            printInOrder(root.right);
        }
    }
    
    

    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
