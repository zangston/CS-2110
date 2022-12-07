/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Homework 2
 * Meme.java
 * September 25, 2020
 */

import java.util.*;

public class Meme {

	//Instance variables
	private User creator;
	private BackgroundImage backgroundImage;
	private ArrayList<Rating> ratings;
	private String caption;
	private boolean shared;
		
	/*
	 * Constructor method
	 * Accepts BackgroundImage, caption, and User as arguments
	 */
	public Meme(BackgroundImage backgroundImage, String caption, User creator)
	{
		this.backgroundImage = backgroundImage;
		this.caption = caption;
		this.creator = creator;
		this.ratings = new ArrayList<Rating>();
		this.shared = false;
	}
	//Default constructor method
	public Meme()
	{
		this.backgroundImage = new BackgroundImage();
		this.caption = "";
		this.creator = new User();
		this.ratings = new ArrayList<Rating>();
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
	
	/*
	 * Method for calculating sum of all upvotes and downvotes on a meme
	 * Returns 0.0 if no ratings are found
	 * Loops through ratings ArrayList and adds up all the scores
	 */
	public double calculateRating()
	{
		if(ratings.size() == 0 || ratings == null)
			return 0.0;
		
		double sum = 0;
		for(Rating r: ratings)
		{
			sum += ((double)r.getScore());
		}		
		return sum;
	}
	
	/*
	 * toString method
	 * returns backgroundImage "caption" UserName(reputation) meme calculated rating [(number of +1 rating) +1 (number of -1 ratings) -1]
	 * e.g. Italian people <Image of Benito Mussolini> "My face when mfw (my face when) when the pasta is perfeto" Winston Zhang (10.0) 10.0 [(10) + 1 (0) -1]	 
	 */
	@Override
	public String toString()
	{
		int plus = 0;
		int minus = 0;
		for(Rating r : ratings)
		{
			if(r.getScore() > 0)
				plus++;
			if(r.getScore() < 0)
			{
				minus++;
			}
		}
		
		String rates = this.calculateRating() + " [(" + plus + ") +1 (" + minus + ") -1]";

		String re = backgroundImage.toString() + " '" + caption + "' " + creator.getUserName() + " (" +
				creator.calculateReputation() + ") " + rates;
		return re;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meme other = (Meme) obj;
		if (backgroundImage == null) {
			if (other.backgroundImage != null)
				return false;
		} else if (!backgroundImage.equals(other.backgroundImage))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		return true;
	}
}