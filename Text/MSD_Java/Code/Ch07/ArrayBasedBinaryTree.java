/**
 * An array based implementation of a binary tree.  Javadoc comments 
 * for methods specified in the BinaryTree interface have been omitted.
 *
 * This code assumes that the preconditions stated in the comments are
 * true when a method is invoked and therefore does not check the
 * preconditions.
 */ 
 
public class ArrayBasedBinaryTree<T> implements BinaryTree<T> {
    // Constants for selecting children
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int FREE = 0;

    // Constants for selecting traversals
    public static final int IN_ORDER = 0;
    public static final int PRE_ORDER = 1;
    public static final int POST_ORDER = 2;
    
    // Marks an empty position in the array
    public static final int OFF_TREE = -1;
    
    // Initial size of the arrays
    public static final int INITIAL_SIZE = 100;
    
    private T data[];          // Array containing node data
    private int children[][];  // The children

    private int root;          // The root node
    private int cursor;        // Current node 
    private int count;         // Number of nodes in the tree

    private int availHead;     // Start of free list

    /**
     * Create a new tree.
     */
    public ArrayBasedBinaryTree() {
    	// Initialize storage arrays

	// Note that the cast is necessary because you cannot
        // create generic arrays in Java.  This statement will
        // generate a compiler warning.
    	data  = (T[])new Object[ INITIAL_SIZE ];
	children = new int[ INITIAL_SIZE ][ 2 ];
		
	// Tree is empty
	root = OFF_TREE;
	cursor = OFF_TREE;
	count = 0;
	
	// Initialize children array
	availHead = 0;
	for ( int i = 0; i < INITIAL_SIZE - 1; i++ ) {
	    // Add this node to our 'free' list.
	    children[ i ][ FREE ] = i + 1;	
	}
	
	// The end of the free list
	children[ INITIAL_SIZE - 1 ][ FREE ] = OFF_TREE;
    }

    public void toRoot() {
    	cursor = root;
    }

    public boolean hasLeftChild() {
    	return children[ cursor ][ LEFT ] != OFF_TREE;
    }

    public boolean hasRightChild() {
    	return children[ cursor ][ RIGHT ] != OFF_TREE;
    }

    public boolean hasParent() {
	int parent = OFF_TREE;
	
	// If there is a tree to search - look for the parent
	if ( root != OFF_TREE ) {
	    parent = findParent( root, cursor );
	}
	
	// If we found a parent return true
	return parent != OFF_TREE;
    }

    public boolean isValid() {
    	return cursor != OFF_TREE;
    }

    public void toParent() {
	// If there is no tree to search - invalidate the cursor
	if ( root == OFF_TREE ) {
	    cursor = OFF_TREE;
	}
	else {
	    // Set the cursor to the parent
	    cursor = findParent( root, cursor );
	}
    }

    public void toLeftChild() {
    	cursor = children[ cursor ][ LEFT ];
    }

    public void toRightChild() {
    	cursor = children[ cursor ][ RIGHT ];
    }

    public void insertLeft( T element ) {
	// Find the place in the arrays where the new node will
	// be placed
	int pos = nextIndex();
	data[ pos ] = element;
	
	// If the tree is empty this becomes the only node in the
	// tree, otherwise make the new node the left child of the
	// cursor
	if ( root == OFF_TREE ) {
	    root = pos;
	}
	else {
	    children[ cursor ][ LEFT ] = pos;
	}
    }

    public void insertRight( T element ) {
	// Find the place in the arrays where the new node will
	// be placed
	int pos = nextIndex();
	data[ pos ] = element;
	
	// If the tree is empty this becomes the only node in the
	// tree, otherwise make the new node the right child of the
	// cursor
	if ( root == OFF_TREE ) {
	    root = pos;
	}
	else {
	    children[ cursor ][ RIGHT ] = pos;
	}
    }

    public T get() {
    	return data[ cursor ];
    }

    public void set( T element ) {
    	data[ cursor ] = element;
    }

    public void prune() {
	int parent = findParent( root, cursor );
	
	// Add the nodes in the tree being deleted to the free list
	freeIndex( cursor );
	
	// Did we delete the entire tree?
	if ( parent == OFF_TREE ) {
	    // Invalidate the root and the cursor
	    root = OFF_TREE;
	    cursor = OFF_TREE;
	} else {
	    // Is it the parent's left child?
	    if ( children[ parent ][ LEFT ] == cursor ) {
		// Deleted the left child
		children[ parent ][ LEFT ] = OFF_TREE;
	    } else {
		// Deleted the right child
		children[ parent ][ RIGHT ] = OFF_TREE;
	    }
	    
	    // Update the cursor
	    cursor = parent;
	}
    }

    public boolean equals( Object o ) {
	boolean retVal = false;
	
	// We can only do the comparison if the other object is a tree
	if ( o instanceof BinaryTree ) {
	    BinaryTree other = (BinaryTree<?>)o;
	    
	    // Start at the top of both trees
	    toRoot();
	    other.toRoot();
	    
	    // Use the recursive helper method to do the actual work
	    retVal = equalHelper( other );
	    
	    // Reset the iterators
	    toRoot();
	    other.toRoot();
	}
	
	return retVal;
    }

    /**
     * Compare the content and structure of this tree to a second
     * binary tree.
     *
     * @param tree the tree to compare this tree with
     *
     * @return true if the content and structure of a given tree is
     *         identical to this tree and false otherwise.
     */
    private boolean equalHelper( BinaryTree<?> tree ) {
	// Handle the case where both trees are empty.  If both
	// trees are empty, they are equal.
	boolean retVal = ( cursor == OFF_TREE && !tree.isValid() );
	
	// If both trees have something in them -- compare them
	if ( cursor != OFF_TREE && tree.isValid() ) {
	    
	    // Both nodes should have the same data and both
	    // should have the same type of children
	    retVal = data[ cursor ].equals( tree.get() ) &&
		hasLeftChild() == tree.hasLeftChild() &&
		hasRightChild() == tree.hasRightChild();
	    
	    // If they are equal and have left children - compare them
	    if ( retVal && hasLeftChild() ) {
		toLeftChild();
		tree.toLeftChild();
		retVal = equalHelper( tree );
		
		// Back up the cursors
		toParent();
		tree.toParent();
	    }
	    
	    // If they are equal and have right children - compare them
	    if ( retVal && hasRightChild() ) {
		toRightChild();
		tree.toRightChild();
		retVal = retVal && equalHelper( tree );
		
		// Back up the cursors
		toParent();
		tree.toParent();
	    }
	}
	
	return retVal;
    }

    public int size() {
    	return count;
    }

    public int height() {
    	int height = 0;
	
	// If there is a tree determine its height
	if ( root != OFF_TREE ) {
	    height = height( root ); 
	}
	
	return height;
    }
    
    /**
     * Determine the height of the tree with the specified root.
     *
     * @param the root of the tree.
     *
     * @return the height of the tree.
     */
    private int height( int root ) {
	int leftHeight = 0;
	int rightHeight = 0;
	int height = 0;
	
	// Determine the height of the left subtree
	if ( children[ root ][ LEFT ] != OFF_TREE ) {
	    leftHeight = height( children[ root ][ LEFT ] );
	}
	
	// Determine the height of the right subtree
	if ( children[ root ][ RIGHT ] != OFF_TREE ) {
	    rightHeight = height( children[ root ][ RIGHT ] );
	}
	
	// The height of the tree rooted at this node is one more than the
	// height of the 'taller' of its children.
	if (leftHeight > rightHeight) {
	    height = 1 + leftHeight;
	} else {
	    height = 1 + rightHeight;
	}
	
	// Return the answer
	return height;
    }

    public void find( T target ) {
	// If there is no tree - cursor should be off the tree
	if ( root == OFF_TREE ) {
	    cursor = OFF_TREE;
	} else {
	    // Find the target and set cursor
	    cursor = search( root, target );
	}
    }
    
    /**
     * Search the tree at the specified root for the given target.
     *
     * @param root the root of the tree to search.
     * @param target the element being looked for.
     *
     * @return the location of the node that contains the target,
     *         or OFF_TREE if the target cannot be found.
     */
    private int search( int root, T target ) {
	int location = OFF_TREE;
	
	// Is the target in the left subtree?
	if ( children[ root ][ LEFT ] != OFF_TREE ) {
	    location = search( children[ root ][ LEFT ], target );
	}
	
	// If we haven't found it, is it in this node?
	if (location == OFF_TREE && target.equals( data[ root ] ) ) {
	    location = root;
	}
	
	// If we haven't found it, and we have a right child, check there
	if ( location == OFF_TREE && 
	     children[ root ][ RIGHT ] != OFF_TREE ){	
	    location = search( children[ root ][ RIGHT ], target );
	}
	
	// Return the location of the target
	return location;
    }

    /**
     * Return a string representation of this tree.  The string
     * returned by this method will show the structure of the
     * tree if the string is rotated 90 degrees to the right.
     * 
     * @return a string representation of this tree.
     */    
    public String toString() {
	StringBuffer retVal = new StringBuffer();
	
	// Get the string
	treeToString( root, retVal, "" );
	
	// Convert the string buffer to a string
	return retVal.toString();
    }

    /**
     * A recursive method that does a RVL traversal of the tree
     * to create a string that shows the contents and structure of
     * the tree.
     *
     * For a tree that has the following structure:
     *
     *                      A
     *                B           C
     *            D       E
     *
     * This method will return the following string
     *
     *     C
     * A
     *         E
     *     B
     *         D
     */
    private void treeToString( int cur, StringBuffer str, String indent ) {
	if ( cur != OFF_TREE ) {
	    // Get the string representation of the right child.  Indent
	    // is increased by 4 since this subtree is one level deeper in
	    // the tree
	    treeToString( children[ cur ][ RIGHT ], str, indent + "    " );
	    
	    // Convert the information in the current node
	    str.append( indent );
	    str.append( data[ cur ].toString() );
	    str.append( "\n" );
	    
	    // Get the string representation of the left child.
	    treeToString( children[ cur ][ LEFT ], str, indent + "    " );
	}
    }
    
    public void preOrder( Callback<T> cb ) {
	// Start the traversal at the root node
	if ( root != OFF_TREE )  {
	    preOrder( root, cb );
	}
    }

    /**
     * Do a pre-order traversal of the tree with the given root.
     *
     * @param root the root of the tree to traverse.
     * @param cb the callback object used to process each node.
     */
    private void preOrder( int root, Callback<T> cb ) {
	// Process the data in the current node
	cb.visit( data[ root ] );
	
	// Process the left child - if there is one
	if ( children[ root ][ LEFT ] != OFF_TREE ) {
	    preOrder( children[ root ][ LEFT ], cb );
	}
	
	// Process the right child - if there is one
	if ( children[ root ][ RIGHT ] != OFF_TREE ) {
	    preOrder( children[ root ][ RIGHT ], cb );
	}
    }

    public void inOrder( Callback<T> cb ) {
	// Start the traversal at the root node
	if ( root != OFF_TREE ) {
	    inOrder( root, cb );
	}
    }

    /**
     * Do a in-order traversal of the tree with the given root.
     *
     * @param root the root of the tree to traverse.
     * @param cb the callback object used to process each node.
     */
    private void inOrder( int root, Callback<T> cb ) {
	// Process the left child - if there is one
	if ( children[ root ][ LEFT ] != OFF_TREE ) {
	    inOrder( children[ root ][ LEFT ], cb );
	}
	
	// Process the current node
	cb.visit( data[ root ] );
	
	// Process the right child - if there is one
	if ( children[ root ][ RIGHT ] != OFF_TREE ) {
	    inOrder( children[ root ][ RIGHT ], cb );
	}
    }

    public void postOrder(Callback<T> cb) {
	// Start the traversal at the root node
	if (root != OFF_TREE) {
	    postOrder( root, cb );
	}
    }

    /**
     * Do a post-order traversal of the tree with the given root.
     *
     * @param root the root of the tree to traverse.
     * @param cb the callback object used to process each node.
     */
    private void postOrder( int root, Callback<T> cb ) {
	// Process the left child - if there is one
	if ( children[ root ][ LEFT ] != OFF_TREE ) {
	    postOrder( children[ root ][ LEFT ], cb );
	}
	
	// Process the right child - if there is one
	if ( children[ root ][ RIGHT ] != OFF_TREE ) {
	    postOrder( children[ root ][ RIGHT ], cb );
	}
	
	// Process the current node
	cb.visit( data[ root ] );
    }
    
    /**
     * Return the position of the parent given a root of the tree
     * and the child.
     *
     * @param root the root of the tree to sreach.
     * @param child the child whose parent we are looking for.
     *
     * @return the location of the parent in the tree or OFF_TREE
     *         if the parent cannot be found.
     */
    protected int findParent( int root, int child ) {
	int parent = OFF_TREE;
	
	// Is the root the parent?
	if ( children[ root ][ LEFT ] == child || 
	     children[ root ][ RIGHT ] == child ) {
	    parent = root;
	} else {
	    // Check left child - if there is one
	    if ( children[ root ][ LEFT ] != OFF_TREE ) {
		parent = findParent( children[ root ][ LEFT ], child );
	    }
	    // If it has not been found - check the right child
	    if ( parent == OFF_TREE && 
		 children[ root ][ RIGHT ] != OFF_TREE ) {
		parent = findParent( children[ root ][ RIGHT ], child );
	    }
	}
	
	return parent;
    }
    
    /**
     * Locate the next open index in the arrays holding the tree nodes.
     * If there is not enough room in the arrays for the new node,
     * the arrays will be expanded.
     *
     * @return the next open index in the node arrays.
     */
    private int nextIndex() {
	int retVal;
	
	// If the free space is gone - expand the arrays
	if ( availHead == OFF_TREE ) {
	    expand();
	}
	
	// Take the location at the front of the list
	retVal = availHead;
	availHead = children[ availHead ][ FREE ];	
	
	// Ensure the location doesn't link to the available list any more
	children[ retVal ][ LEFT ] = OFF_TREE;
	children[ retVal ][ RIGHT ] = OFF_TREE;
	
	// One more node in the tree
	count = count + 1;
	
	// Return the index	
	return retVal;
    }
    
    /**
     * Double the capacity of the arrays that hold the data and the
     * links.
     */
    private void expand() {
	// Make the new arrays twice the size of the old arrays

	// Note that the cast is necessary because you cannot
        // create generic arrays in Java.  This statement will
        // generate a compiler warning.

	T newData[] = (T[])new Object[ data.length * 2 ];
	int newChildren[][] = new int[ newData.length ][ 2 ];
	
	// Copy the contents of the old arrays to the new arrays
	for ( int i = 0; i < data.length; i = i + 1 ) {
	    newData[ i ] = data[ i ];
	    newChildren[ i ][ LEFT ] = children[ i ][ LEFT ];
	    newChildren[ i ][ RIGHT ] = children[ i ][ RIGHT ];
	}
	
	// Add the empty space to the available list
	for ( int i = data.length; i < newData.length; i++ ) {
	    newChildren[ i ][ FREE ] = availHead;
	    availHead = i;
	}
	
	// Start using the new arrays
	data = newData;
	children = newChildren;
    }

    /**
     * Add the array locations occupied by the specified tree to the
     * free list.
     *
     * @param root the root of the tree to delete.
     */
    private void freeIndex( int root ) {
	// Add the nodes in the left tree to the free list
	if ( children[ root ][ LEFT ] != OFF_TREE ) {
	    freeIndex( children[ root ][ LEFT ] );
	    children[ root ][ LEFT ] = OFF_TREE;
	}
	
	// Add the nodes in the right tree to the free list
	if ( children[ root ][ RIGHT ] != OFF_TREE ) {
	    freeIndex( children[ root ][ RIGHT ] );
	    children[ root ][ RIGHT ] = OFF_TREE;
	}
	
	// Add this node to the free list
	children[ root ][ FREE ] = availHead;
	availHead = root;
	
	// One less node in the tree
	count = count - 1;
    }
    
} // ArrayBasedBinaryTree
