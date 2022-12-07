/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Homework 1
 * Meme.java
 * September 18, 2020
 */

import java.util.*;

public class Meme {

	//Instance variables
	private User creator;
	private BackgroundImage backgroundImage;
	private ArrayList<Rating> ratings;
	private String caption;
	private boolean shared;
	
	//Constructor
	public Meme(User creator, BackgroundImage backgroundImage, ArrayList<Rating> ratings, String caption, boolean shared) 
	{
		this.creator = creator;
		this.backgroundImage = backgroundImage;
		this.ratings = ratings;
		this.caption = caption;
		this.shared = shared;
	}	
	//Default constructor
	public Meme()
	{
		this.creator = null;
		this.backgroundImage = null;
		this.ratings = null;
		this.caption = null;
		this.shared = false;
	}
	
	//Getter methods for instance variables
	public User getCreator() {
		return creator;
	}	
	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}
	public ArrayList<Rating> getRatings() {
		return ratings;
	}
	public String getCaption() {
		return caption;
	}
	public boolean getShared() {
		return shared;
	}
	
	//Setter methods for instance variables
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public void setBackgroundImage(BackgroundImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	
	//Class behavior methods
	@Override
	public String toString()
	{
		return "";
	}
	
	@Override
	public boolean equals(Object other)
	{
		return true;
	}
		
}
