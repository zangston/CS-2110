/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Lab Activity 12
 * PancakeMakerTest.java
 * JUNIT 4 Test Case
 * 30. September 2020
 */

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class PancakeMakerTest {

	@Test
	public void determineWholeFoodsOrderTest() 
	{
		PancakeMaker myPancakeMaker = new PancakeMaker();
		String[] ingredientsIHave = { "flour","salt","soda","powder","buttermilk"};
		
		ArrayList<String> expected = new ArrayList<String>();
		
		expected.add("egg");
		
		assertEquals("Error returning correct order", expected, myPancakeMaker.determineWholeFoodsOrder(ingredientsIHave));
	}
	
	/* The test method below is what would cause the same exact test as above to pass
	 * this is due to the nested for loops in the determineWholeFoodsOrder method,
	 * as the for loop will not add an ingredient that equals a required ingredient,
	 * but will add that ingredient once iterating through the rest of the array after
	 * finding a match, resulting in many duplicates being added for both ingredients
	 * already in inventory, as well as ingredients not in possession
	 * 
	 * for this case, the method sees that one String in the array is flour, but the other 
	 * four are not, so it adds "flour" four times to the ArrayList for every other ingredient.
	 * once the loop iterating through ingredientsRequired reaches eggs, it adds eggs five times,
	 * as eggs is not present at all in the ingredientsIHave array
	 * 
	 * the program will return an ArrayList of (ingredientsIHave.size - 1) duplicates of ingredients already
	 * in possession, and (ingredientsIHave.size) duplicates of ingredients not in possession
	 */
	
	@Test
	public void determineWholeFoodsOrderTestB() 
	{
		PancakeMaker myPancakeMaker = new PancakeMaker();
		String[] ingredientsIHave = { "flour","salt","soda","powder","buttermilk"};
		
		ArrayList<String> expected = new ArrayList<String>();
		
		expected.add("flour");
		expected.add("flour");
		expected.add("flour");
		expected.add("flour");
		expected.add("salt");
		expected.add("salt");
		expected.add("salt");
		expected.add("salt");
		expected.add("soda");
		expected.add("soda");
		expected.add("soda");
		expected.add("soda");
		expected.add("powder");
		expected.add("powder");
		expected.add("powder");
		expected.add("powder");
		expected.add("buttermilk");
		expected.add("buttermilk");
		expected.add("buttermilk");
		expected.add("buttermilk");
		expected.add("egg");
		expected.add("egg");
		expected.add("egg");
		expected.add("egg");
		expected.add("egg");
		
		assertEquals("Error returning correct order", expected, myPancakeMaker.determineWholeFoodsOrder(ingredientsIHave));
	}
	
	/*This test will call the determineWholeFoodsOrder method and pass in an array with
	 * "flour", "salt", and "eggs"
	 * The ArrayList returned should have 2 strings "flour", 2 strings "salt", 3 strings "soda",
	 * 3 strings "powder", 3 strings "buttermilk" and 2 strings "egg"
	 * 
	 * This test should fail
	 */
	@Test
	public void determineWholeFoodsOrderTest2()
	{
		PancakeMaker myPancakeMaker = new PancakeMaker();
		String[] ingredientsIHave = { "flour","salt","egg"};
		
		ArrayList<String> expected = new ArrayList<String>();
		
		expected.add("soda");
		expected.add("powder");
		expected.add("buttermilk");
		
		assertEquals("Error returning correct order", expected, myPancakeMaker.determineWholeFoodsOrder(ingredientsIHave));
	}

	/* This test passes in an empty Array
	 * This also does not pass because the nested for loop will not execute,
	 * as ingredientsIHave.size is already 0, so no Strings are added to the
	 * ArrayList returned by the method
	 */
	@Test
	public void determineWholeFoodsOrderTest3()
	{
		PancakeMaker myPancakeMaker = new PancakeMaker();
		String[] ingredientsIHave = {};
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("flour");
		expected.add("salt");
		expected.add("soda");
		expected.add("powder");
		expected.add("buttermilk");
		expected.add("egg");
		
		assertEquals("Error returning correct order", expected, myPancakeMaker.determineWholeFoodsOrder(ingredientsIHave));
	}
	
	/* Likewise, passing in an array with every ingredient needed will
	 * return an ArrayList with 5 duplicate Strings of each ingredient
	 */
	@Test
	public void determineWholeFoodsOrderTest4()
	{
		PancakeMaker myPancakeMaker = new PancakeMaker();
		String[] ingredientsIHave = {"flour", "salt", "soda", "powder", "buttermilk", "egg"};
		
		ArrayList<String> expected = new ArrayList<String>();
		
		assertEquals("Error returning correct order", expected, myPancakeMaker.determineWholeFoodsOrder(ingredientsIHave));
	}
}
