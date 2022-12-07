/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Homework 1
 * Feed.java
 * September 18, 2020
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
	
	//Default constructor
	public Feed()
	{
		this.memes = null;
	}

	//Getter and setter methods for instance varible
	public ArrayList<Meme> getMemes() {
		return memes;
	}
	public void setMemes(ArrayList<Meme> memes) {
		this.memes = memes;
	}
	
	//Class behavior methods
	public Meme getNewMeme(User user)
	{
		return null;
	}
	
	@Override
	public String toString()
	{
		return "";
	}
	
}
