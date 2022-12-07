/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Homework 2
 * Feed.java
 * September 25, 2020
 */

import java.util.*;

public class Feed {

	//Single instance variable
	private ArrayList<Meme> memes;
	
	//Constructor
	public Feed(ArrayList<Meme> memes)
	{
		this.memes = memes;
	}
	
	public Feed()
	{
		this.memes = new ArrayList<Meme>();
	}

	//Getter and setter methods for instance variable
	public ArrayList<Meme> getMemes() {
		return memes;
	}
	public void setMemes(ArrayList<Meme> memes) {
		this.memes = memes;
	}
	
	/*
	 * returns a meme in the feed that the user has not seen or created
	 */
	public Meme getNewMeme(User user)
	{
		for(Meme m : memes)
		{
			if(!user.getMemesViewed().contains(m) && !user.getMemesCreated().contains(m))
			{
				return m;
			}
		}
		return null;
	}
	
	/*
	 * toString method, returns all memes in the feed, each meme on a new line
	 */
	@Override
	public String toString()
	{
		String s = "";
		for(Meme m : memes)
		{
			s += m.toString() + "\n";
		}
		return s;
	}
	/*
	public static void main(String[]arg)
	{
		ArrayList<Meme> sharedList = new ArrayList<Meme>();
		Feed sharedFeed = new Feed(sharedList);
		
		User alex = new User("Alex");
		User ben = new User("Ben");
		User chuck = new User("Chuck");
		
		BackgroundImage knuckles = new BackgroundImage("ungandanknuckles", "Do you know da wae", "Image of Knuckles");
		BackgroundImage girlfriend = new BackgroundImage("obsessedgf", "Overly Obsessed Girlfriend", "Image of white girl smiling");
		BackgroundImage peter = new BackgroundImage("pg", "Peter Griffin", "Image of Peter Griffin");
		
		Meme knucklesMeme = alex.createMeme(knuckles, "*sings hamster song");
		Meme gfMeme = ben.createMeme(girlfriend, "haram babe");
		Meme peterMeme = chuck.createMeme(peter, "i am wanted in multiple balkan countries for war crimes against humanity");
		
		alex.shareMeme(knucklesMeme, sharedFeed);
		ben.shareMeme(gfMeme, sharedFeed);
		chuck.shareMeme(peterMeme, sharedFeed);
		
		//alex.rateNextMeme(sharedFeed, -1);
		
		for(int i = 0; i < sharedFeed.getMemes().size(); i++)
		{
			int ratingScore = (int)(Math.random() * 3) - 1;
			alex.rateNextMeme(sharedFeed, ratingScore);
		}
		for(int i = 0; i < sharedFeed.getMemes().size(); i++)
		{
			int ratingScore = (int)(Math.random() * 3) - 1;
			ben.rateNextMeme(sharedFeed, ratingScore);
		}
		for(int i = 0; i < sharedFeed.getMemes().size(); i++)
		{
			int ratingScore = (int)(Math.random() * 3) - 1;
			chuck.rateNextMeme(sharedFeed, ratingScore);
		}
				
		/*
		 * As of now, the console prints out ratings and reputation as 0 and 0.0 because 
		 * rateMeme() in the User class has not been implemented yet
		 */
		/*
		System.out.println(sharedFeed.toString());
		System.out.println(alex.toString() + "\n" + ben.toString() + "\n" + chuck.toString());
	}*/
}
