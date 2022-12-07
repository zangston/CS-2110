
/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 *
 * Used for Binary Search Tree (BST) activity
 *
 * @param <T> The type of data this tree node stores
 */

public class BinaryTreeNode<T> {

    /**
     * Reference pointer to the left subtree
     */
    private BinaryTreeNode<T> left;

    /**
     * Reference pointer to the right subtree
     */
    private BinaryTreeNode<T> right;

    /**
     * Data stored at this node
     */
    private T data;

    /**
     * Default Constructor [1]
     * 
     * Creates a binary tree node with null data and null children
     */
    public BinaryTreeNode(){
        this(null,null,null); // calls full Constructor [3] passing three null values; thus assigning all to null
    }

    /**
     * Data-only Constructor [2]
     * 
     * Creates a binary tree node with the given data and null children
     * 
     * @param theData The data to store at this node
     */
    public BinaryTreeNode(T theData){
        this(theData,null,null); // calls full Constructor [3] where left and right values are null
    }							 // thus: this.data = theData; this.left = null; this.right = null; 


    /**
     * Full Constructor [3]
     * 
     * Creates a binary tree node with the given data and child reference pointers
     * 
     * @param theData The data to store at this node
     * @param leftChild A reference pointer to the left subtree
     * @param rightChild A reference pointer to the right subtree
     */
    public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
        this.data = theData;
        this.left = leftChild;
        this.right = rightChild;
    }


    /**
     * Left Child/Subtree getter
     * 
     * @return A reference pointer to the root of the left subtree
     */
    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    /**
     * Left Child/Subtree Setter
     * 
     * @param left A reference pointer to the new left subtree's root node
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Right Child/Subtree getter
     * 
     * @return A reference pointer to the root of the right subtree
     */
    public BinaryTreeNode<T> getRight() {
        return this.right;
    }

    /**
     * Right Child/Subtree Setter
     * 
     * @param left A reference pointer to the new right subtree's root node
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    /**
     * Get the data at this node
     * 
     * @return The data stored at this node
     */
    public T getData() {
        return this.data;
    }

    /**
     * Set the data at this node
     * 
     * @param data The data to be stored at this node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * toString method
     * (Written in a unique way - can you tell what it represents?)
     */
    @Override
    public String toString() {
        String retVal = "";
        if (this.left != null)
            retVal += this.left.toString(); // recursive call on left
        if (this.right != null) 
            retVal += this.right.toString(); // recursive call on right
        retVal += "("+this.data+")"; // add this node's data
        return retVal;
    }


    /**
     * Main method
     * 
     * Your code should go here
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

		// Create a BinaryTreeNode that holds data of type Integer
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(6);
		// Create all the other nodes...
		

		//TODO: Add your code here to build a Binary Search Tree based on the provided input values 

        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(4);
        root.setLeft(n2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(3);
        n2.setLeft(n3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(5);
        n2.setRight(n4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(8);
        root.setRight(n5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(9);
        n5.setRight(n6);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(1);
        n3.setLeft(n7);
        BinaryTreeNode<Integer> n8 = new BinaryTreeNode<Integer>(2);
        n7.setLeft(n8);
        
        //Print the tree using toString() method (starting at the root of the tree) 
        System.out.println("Printing the tree:");
        System.out.println(root.toString());
		//Check your output matches our output (see in-class activity!) 
    }

}