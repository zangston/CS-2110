/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Homework 1
 * Rating.java
 * Setpember 18, 2020
 */


public class Rating {

	//Instance variables
	private int score;
	private User user;
	
	//Constructor
	public Rating(int score, User user)
	{
		this.score = score;
		this.user = user;
	}
	
	//Default constructor
	public Rating()
	{
		this.score = 0;
		this.user = null;
	}

	//Getter methods for instance variables
	public int getScore() {
		return score;
	}
	public User getUser() {
		return user;
	}

	//Setter methods for instance variables
	public void setScore(int score) {
		this.score = score;
	}
	public void setUser(User user) {
		this.user = user;
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
