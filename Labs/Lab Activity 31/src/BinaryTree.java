/**
 * Binary Tree Class
 * 
 * The head class for a binary tree implementation.
 * 
 * @param <T> Type of data to store in the binary tree
 */
public class BinaryTree<T> {

	/**
	 * A reference pointer to the root of the tree
	 */
	private BinaryTreeNode<T> root;

	/**
	 * Default constructor [1]
	 * 
	 * Creates a binary tree object with null root note (empty tree)
	 */
	public BinaryTree() {
		this(null); // calls the second constructor with one parameter; effectively, this.root = null; 
	}

	/**
	 * Constructor [2]
	 * 
	 * Creates a binary tree object with the given node as root
	 * 
	 * @param newRoot The root of the tree
	 */
	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	/**
	 * Get the root of the tree
	 * 
	 * @return The root of the tree
	 */
	public BinaryTreeNode<T> getRoot() {
		return this.root;
	}

	/**
	 * Set the root of the tree
	 * 
	 * @param root  The new root of this tree
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}
	
	/**
	 * toString method
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    if (this.root != null)
	        return this.root.toString();
	    return "Empty tree";
	}
 	
	
}