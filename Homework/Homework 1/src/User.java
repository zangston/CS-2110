/*
 * User.java
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Homework 1
 * September 18, 2020
 */

import java.util.*;

public class User {

	//Instance variables
	private String userName;
	private ArrayList<Meme> memesCreated;
	private ArrayList<Meme>	memesViewed;
	
	//Constructor method
	public User(String userName, ArrayList<Meme> created, ArrayList<Meme> viewed)
	{
		this.userName = userName;
		this.memesCreated = created;
		this.memesViewed = viewed;
	}	
	//Default constructor
	public User()
	{
		this.userName = null;
		this.memesCreated = null;
		this.memesViewed = null;
	}
	
	//Getter methods for instance variables
	public String getUserName() 
	{
		return userName;
	}	
	
	public ArrayList<Meme> getMemesCreated() 
	{
		return memesCreated;
	}
	
	public ArrayList<Meme> getMemesViewed() 
	{
		return memesViewed;
	}
	
	//Setter methods for instance variables
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public void setMemesCreated(ArrayList<Meme> memesCreated) 
	{
		this.memesCreated = memesCreated;
	}
	
	public void setMemesViewed(ArrayList<Meme> memesViewed) 
	{
		this.memesViewed = memesViewed;
	}
	
	//Class behavior methods
	public void rateMeme(Meme m, int rating)
	{		
	}
	
	public Meme createMeme(BackgroundImage b, String caption)
	{
		return null;
	}
	
	public boolean deleteMeme(Meme m)
	{
		return false;
	}
	
	public void shareMeme(Meme m, Feed f)
	{
	}
	
	public void rateNextMeme(Feed f, int ratingScore)
	{
	}
	
	public double calculateReputation()
	{
		return 0.0;
	}
	
	//Returns a string stating instance variables and general state
	@Override
	public String toString()
	{
		return "";
	}
	//Compares passed in object to self, returns true if instance variables are equal
	@Override
	public boolean equals(Object other)
	{
		return true;
	}
}
