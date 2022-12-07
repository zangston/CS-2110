/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * September 23, 2020
 * Lab Activity 10
 * NameChooser.java
 */

import java.util.*;

public class NameChooser {
	
	public static void main (String[] arg)
	{
		//Constructor in main method as the names method is not static, so we need an object to call the method
		NameChooser n = new NameChooser();
		
		HashSet<String> cards = new HashSet<String>();
		HashSet<String> topNames = new HashSet<String>();
		
		//These arrays are to be looped over to add to the HashSets and are for testing purposes only
		String[] arr = {"James", "Noah", "Will", "Jack", "Tucker"};	
		String[] arr2 = {"Liam", "Noah", "Oliver", "William", "Elijah", "Henry", "Ben", "Ethan"};
		for(int i = 0; i < arr.length; i++) 
		{
			cards.add(arr[i]);
		}
		for(int i = 0; i < arr2.length; i++) 
		{
			topNames.add(arr2[i]);
		}
		
		//Testing to see if HashSets are properly populated
		/*

		for(String i : cards) 
		{
			System.out.println(i);
		}
		System.out.println("\n");
		for(String i : topNames)
		{
			System.out.println(i);
		}
		
		*/
		
		HashSet<String> allNames = n.names(cards, topNames);
		for(String i : allNames)
		{
			System.out.println(i);
		}
	}
	
	/* 
	 * This method takes in a set of names from the hat and a set of names from the list
	 * and returns a set of names from the hat and the top names, excluding duplicate names
	 */
	public HashSet<String> names(HashSet<String> cards, HashSet<String> topNames)
	{
		HashSet<String> names = new HashSet<String>();
		for(String i : cards)
		{
			names.add(i);
		}
		for(String i : topNames)
		{
			names.add(i);
		}
		
		return names;
	}
}
