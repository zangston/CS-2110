import java.io.File;

/**
 * <p>Fresh off your work for the Nautilus9, you once again are set adrift in the gig economy.</p>
 * 
 * <p>Word quickly gets out about your work with the sophisticated
 * equipment aboard the research vessel, however, and you aren't unemployed for very long.
 * Opening your computer for the news of the day, you notice your inbox contains an intriguing job offer
 * from IMDB, the company that tracks information about the entertainment industry.</p>
 * 
 * <p>After an invitation over Zoom and some fierce salary negotiations, they tell you the problem.
 * IMDB offers data services over the web to other companies. Unfortunately, the service returning information
 * about actors is running so slowly, it is crashing their web services!</p> 
 * 
 * <p>Once you have access to the source code, the problem is obvious. Their data set of Actors contains > 10M
 * records and they are searching for Actors using linear search. You make a mental note to make a meme 
 * for this ridiculous design decision once you are off the clock.</p>
 * 
 * <p>Your days in CS have prepared you well for this problem, however, because you know lists are optimized
 * for keeping things in order, and are fast for adding elements and maintaining a count, but are not so 
 * great for searching. You know what this problem needs... a Binary Search Tree. (BST)</p>
 * 
 * <p>You conceive of a custom BST data structure organizing all the Actors and allowing the web services to
 * perform binary search. You realize what you need to do first is construct a demonstration that will
 * allow you to try linear search and binary search and demonstrate the performance advantage.</p>
 * 
 * <p>All the classes have been created for you, you must implement the ActorTree class methods.
 * If your BST works correctly, searches made against it should return in almost no time at all.</p>
 * 
 * <p>This class, ActorQueryTool, runs the queries for you. If your computer has enough memory to
 * load the entire data set, you can search for ANY actor! The subject of your
 * search, Mr Wilson, is far enough down in the data file to provide an example of how much
 * faster searching with Binary Search is. </p>
 * 
 * <p>11/12/2020
 * 
 * @author Your friendly CS professors</p>
 *
 */
public class ActorQueryTool {
	
	// use this value to limit the amount of data loaded into memory
	// (if your computer is low on memory and locks up when running, 1_000_000 is enough)
	final static int MAXIMUM_NUMBER_RECORDS = 4_000_000;
	final static String NAME_TO_FIND = "Rainn Wilson";

	public static void main(String[] args) {
		//Initialize the DataParser, which will read the file and load the data structures
		DataParser dp = new DataParser(new File("name.basics.tsv"), MAXIMUM_NUMBER_RECORDS);
		
		//System.currentTimeMillis() is a useful method for timing how long it takes to run an algorithm
		long startListSizeTime = System.nanoTime();
		System.out.println(dp.getListDataStore().size() + " items searched.");
		System.out.println("List sizing completed in " + (System.nanoTime() - startListSizeTime) +" nano seconds");

		// record the current time
		long startListQueryTime = System.nanoTime();
		
		Actor a = new Actor();
		
		// search the list data structure sequentially
		for (int i = 0; i < dp.getListDataStore().size(); i++) {
			a = dp.getListDataStore().get(i);
			if (a.getPrimaryName().equals(NAME_TO_FIND)) {
				// we found the record, we can exit the loop with this data
				break;
			} else {
				// if we don't set our test value to null, the last item is returned as a match
				a=null;
			}
		}
		if (a == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found!");
			System.out.println(a);
		}
		
		System.out.println("Sequential search completed in " + (System.nanoTime() - startListQueryTime));

		// Binary Search Trees provide fast searching, but other methods like size() can take longer
		long startTreeSizeTime = System.currentTimeMillis();
		System.out.println(dp.getTreeDataStore().size() + " items searched.");
		System.out.println("Tree size completed in " + (System.currentTimeMillis() - startTreeSizeTime)+" nano seconds");

		// search the tree data structure with binary search
		final long startTreeQueryTime = System.nanoTime();
		Actor b = new Actor();
		b = dp.getTreeDataStore().find(NAME_TO_FIND);

		if (b == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found!");
			System.out.println(b);
		}
		final long endTreeQueryTime = System.nanoTime();
		System.out.println("Binary search completed in " + (endTreeQueryTime - startTreeQueryTime) +" nano seconds");

		System.out.println("Resulting BST has a height of " + dp.getTreeDataStore().height());
		
		//this method should print out all the actors in order
		// You may want to set the number of items to search down to a smaller number
		//System.out.println(dp.getTreeDataStore().inOrder());
	}

}
