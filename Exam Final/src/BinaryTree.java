/**
 * This class is a binary tree, but NOT a binary search tree.
 * Elements are not stored in any meaningful order. You do not need
 * to edit or add anything to this class. This tree stores ints
 * (it is not generic!)
 */
public class BinaryTree {
    // Attribute of the BinaryTree class 
    public Node root; // The root of the BinaryTree (it is of type Node) 
    
    public BinaryTree() { // Default constructor
        this.root = new Node(); //null
    }
    public BinaryTree(Node newRoot) { // Constructor that takes in a Node 
        this.root = newRoot; // "newRoot" becomes the root of the BinaryTree (via the constructor)
    }    

    public void setRoot(Node newRoot) { // Set the root of the tree to "newRoot" (via setter) 
        this.root = newRoot;
    }    
    
    /**
     * BinaryTree version of printTree() method.
     * Printing the elements in a tree using the inOrder tree traversal
     */
    public String printTree() {
        if (this.root == null) { // If there BinaryTree is empty...
            return ">>> Empty Tree!"; // Nothing to print out, so print ">>> Empty Tree!"
        }
        return this.root.printTree(); // Otherwise, call printTree() in Node class
    }
    /**
     * BinaryTree version of leaves() method.
     * @param target
     * @return the number of leaves in the tree that has a value greater than the "target"
     */
    public int leaves(int target) {
        if (this.root == null) { // If the BinaryTree is empty...  
            return 0; // Then return zero (0) -- no nodes that meet the criteria in an empty tree
        }
        return root.leaves(target); // Otherwise, call leaves() in Node class
    }

  
    
    /**
     * This is the Node class for the BinaryTree class. This stores ints,
     * and only ints. It is not generic. Remember: this is NOT a binary
     * search tree, so do not assume anything about the order of elements.
     */
    public class Node {
        // Attributes of the Node class
        public int value; // the int value stored at this node
        public Node left; // pointer to the left subtree
        public Node right;// pointer to the right subtree

        public Node() { // Default constructor
            this.value = 0;
            this.left = null;
            this.right = null;
        }     
        public Node(int newVal) { // Constructor that takes in an item for value
            this.value = newVal;
            this.left = null;
            this.right = null;
        }         

        public String printTree() { // a method to print out the binary tree elements
            // this print method is based on the inOrder tree traversal method
            String s = "";
            if (this.left != null) { 
                s += this.left.printTree();
            }
            s+= this.value + " "; // print the root's value
            if (this.right != null) { 
                s+= this.right.printTree();
            }
            return s;
        }

        public int leaves(int target) {
            //Return the number of nodes in the tree that are
            // (1) a leaf node, AND
            // (2) has a "value" greater than the "target"
            // (If a leaf node has a "value" less or equal to the target, don't count it.)

            //Remember, this is NOT a binary search tree (BST), so you
            //cannot assume anything about the order of values.

            //Write your solution HERE: 
            //(Do NOT change anything else in these classes other than the main() method)
                	
            if(this.left == null && this.right == null)
            {
            	if(this.value > target)
            		return 1;
            	else return 0;
            }
            else if(this.left != null && this.right == null)
            	return this.left.leaves(target);
            else if(this.left == null && this.right != null)
            	return this.right.leaves(target);
            else //if(this.left != null && this.right != null)
            	return this.left.leaves(target) + this.right.leaves(target);

        } // END leaves method

        public void setLeft(Node left) { // Left Child/Subtree Setter
            this.left = left;
        }

        public void setRight(Node right) { // Right Child/Subtree Setter
            this.right = right;
        }



    } // END Node Class
    
    
    public static void main(String[] args){ // Main method: Run this to test leaves() method.
        // (Feel free to edit the main method to do more testing of your code - optional)
        
    	// Create binary tree:
        BinaryTree bt = new BinaryTree(); 
        
        //Create nodes (with int data values) 
        Node n1 = bt.new Node(1);  Node n2 = bt.new Node(2);  Node n3 = bt.new Node(3);
        Node n4 = bt.new Node(4);  Node n5 = bt.new Node(5);  Node n6 = bt.new Node(6);
        Node n7 = bt.new Node(7);  Node n8 = bt.new Node(8);  Node n9 = bt.new Node(9);
        
        // set the root of the tree "bt" 
        bt.setRoot(n6); // root = n6, with value 6
        
        // Building the binary tree
        bt.root.setRight(n1);
        bt.root.setLeft(n8);
        n1.setRight(n7);
        n8.setRight(n3);
        n8.setLeft(n5);
        n7.setRight(n4);
        n7.setLeft(n2);
        n3.setLeft(n9);        
        //Print the tree using toString() method (starting at the root of the tree)
        int target = 5; 
        System.out.println("Output after calling leaves() with target " + target + ":");
        System.out.println(bt.leaves(5)); // call leaves with target = 5 

        // Un-comment the following line if you wish to print the elements of the tree out
        //String outInOrder = bt.printTree();

    }
  
}