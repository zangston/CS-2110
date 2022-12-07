/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Lab Activity 11
 * September 23. 2020
 * LabActivity11.java
 */

import java.util.*;

public class LabActivity11 {

    /**
    * This method (names) takes in two sets: one of names already on cards
    * and the other containing the top 100 names. The method returns
    * a set of names for the new cards needed (in topNames but not in cards) 
    */
    public static HashSet<String> names(HashSet<String> cards, HashSet<String> topNames)
    {
    	HashSet<String> names = new HashSet<String>();
    	//First loop adds all names already on cards
		for(String i : cards)
		{
			names.add(i);
		}
		//Next loop adds names from list, duplicates automatically omitted because we are adding to a Set
		for(String i : topNames)
		{
			names.add(i);
		}
		
		return names;
    }
    
    /**
    * This method (reverseBook) takes a TreeMap representation of a phonebook
    * (Key=Name, a String, and Value=Number, an Integer).
    * The method returns the reverse phonebook (that is, you know the number
    * and you're looking for the name)
    */  
    public static TreeMap<Integer, String> reverseBook(TreeMap<String, Integer> phoneBook)
    {
		TreeMap<Integer, String> reversed = new TreeMap<Integer, String>();
		for(Map.Entry<String, Integer> entry : phoneBook.entrySet())
		{
			reversed.put(entry.getValue(), entry.getKey());
		}
		return reversed;
    }
    
    
    public static void main(String[] args) {
        
        // Do your testing here: 
    	
    	//Part A testing copied from Lab Activity 10
    	HashSet<String> cards = new HashSet<String>();
		HashSet<String> topNames = new HashSet<String>();
		
		//These arrays are to be looped over to add to the HashSets and are for testing purposes only
		String[] arr = {"James", "Noah", "Will", "Jack", "Tucker"};	
		String[] arr2 = {"Liam", "Noah", "Oliver", "William", "Elijah", "Henry", "Ben", "Ethan"};
		for(int i = 0; i < arr.length; i++) 
		{cards.add(arr[i]);}
		for(int i = 0; i < arr2.length; i++) 
		{topNames.add(arr2[i]);}
		
		HashSet<String> allNames = names(cards, topNames);
		for(String i : allNames)
		{System.out.println(i);}
		
		System.out.println("\n");
		
		//Part B testing
		TreeMap<String, Integer> phoneBook = new TreeMap<String, Integer>();
		phoneBook.put("John", 703);
		phoneBook.put("Tim", 571);
		for(Map.Entry<String, Integer> entry : phoneBook.entrySet())
		{
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		System.out.println("\n");
		TreeMap<Integer, String> reversed = new TreeMap<Integer, String>();
		reversed = reverseBook(phoneBook);
		for(Map.Entry<Integer, String> entry : reversed.entrySet())
		{
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
    }

}