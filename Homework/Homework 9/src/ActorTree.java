/**
 * This is the class you will create
 * 
 * @author Your friendly CS professors
 *
 */
public class ActorTree {
	/**
	 * ActorTree has only one property, the root node
	 */
	Node root;

	/**
	 * Initialize the root node in the default constructor
	 */
	public ActorTree() {
		root = new Node();
	}

	/**
	 * 
	 * @param name
	 *            - the name to find
	 * @return the matching Actor object
	 */
	public Actor find(String name) {
		if(isEmpty())
			return null;
		return root.find(name);
	}

	/**
	 * 
	 * @return an int representing 1 for each node in the tree
	 * 
	 */
	public int size() {
		if(isEmpty())
			return 0;
		else
			return root.size();
	}

	/**
	 * 
	 * @return an int representing the maximum height of any branch
	 */
	public int height() {
		if(isEmpty())
			return 0;
		else 
			return root.height();
		
	}

	/**
	 * an empty tree is one with no data
	 * 
	 * @return boolean - True if the tree is empty
	 */
	public boolean isEmpty() {
		if(root.actor == null)
			return true;
		return false;
	}

	/**
	 * 
	 * @param a
	 *            - an Actor object
	 * @return boolean - True if the element was inserted
	 */
	public boolean insert(Actor a) {
		return root.insert(a);
	}
	/**
	 * In order Traversal
	 */
	public String inOrder() {
		return root.inOrder();
	}

	/**
	 * The Node class is an inner class of the ActorTree This is a Binary Search
	 * Tree, so each Node will have left and right children
	 * 
	 * @author Your friendly CS Professors
	 *
	 */
	class Node {
		Actor actor;
		Node left;
		Node right;

		/**
		 * default constructor
		 */
		public Node() {
			actor = null;
			left = null;
			right = null;
		}

		/**
		 * Constructor that takes an Actor object
		 * 
		 * @param a
		 *            - an Actor left and right children are initialized to null
		 */
		public Node(Actor a) {
			actor = a;
			left = null;
			right = null;
		}

		/**
		 * The size method is recursive
		 * 
		 * @return an int to represent a count of all nodes
		 */
		public int size() {
			int x = 0;
			if(actor == null)
				return 0;
			else 
				{
					x++;
					if(left != null)
						x += left.size();
					if(right != null)
						x += right.size();
				}
			return x;
		}

		/**
		 * The height method is recursive
		 * 
		 * @return an int to represent the maximum height of right or left child nodes,
		 *         plus 1 for the current node
		 */
		public int height() {
			if(actor == null)
				return 0;
			
			int leftHeight = 0;
			int rightHeight = 0;
			
			if(left != null)
				leftHeight = left.height();
			if(right != null)	
				rightHeight = right.height();
			if(leftHeight > rightHeight)
				return 1 + leftHeight;
			else
				return 1 + rightHeight;
		}
		
		/**
		 * The insert method finds the best place to insert the Actor argument
		 * 
		 * @param a
		 *            - an Actor to insert
		 * @return boolean - True if the Actor argument was added, false otherwise
		 */
		public boolean insert(Actor a) {
			if(actor == null)
			{
				actor = a;
				return true;
			}
			
			if(actor.compareTo(a) > 0)
			{
				if(left != null)
					return left.insert(a);
				else
					left = new Node(a);
				return true;
			}
				
			if(actor.compareTo(a) < 0)
			{
				if(right != null)
					return right.insert(a);
				else
					right = new Node(a);
				return true;
			}
			return false;
		}

		/**
		 * The find method returns an Actor object with a matching name
		 * 
		 * @param name
		 *            - the name to search for
		 * @return the searched for Actor, or null
		 */
		public Actor find(String name) {
			if(actor == null)
				return null;
			
			if(actor.getPrimaryName().equals(name))
				return actor;
			else if(actor.getPrimaryName().compareTo(name) > 0)
				return left.find(name);
			else if(actor.getPrimaryName().compareTo(name) < 0)
				return right.find(name);
			return null;
		}
		public String inOrder() {
			String re = "";
			if(actor != null)
			{
				if(left != null)
					re += left.inOrder();
				re += actor.toString() + "\n";
				if(right != null)
					re += right.inOrder();
			}
			return re;
		}
	}
	
}