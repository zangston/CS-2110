/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Homework 1
 * BackgroundImage.java
 * September 18, 2020
 */

public class BackgroundImage {

	//Instance variables
	private String imageFileName;
	private String title;
	private String description;
	
	//Constructor
	public BackgroundImage(String imageFileName, String title, String description)
	{
		this.imageFileName = imageFileName;
		this.title = title;
		this.description = description;
	}
	//Default constructor
	public BackgroundImage()
	{
		this.imageFileName = null;
		this.title = null;
		this.description = null;
	}
	
	//Getter methods for instance variables
	public String getImageFileName() 
	{
		return imageFileName;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	//Setter methods for instance variables
	public void setImageFileName(String imageFileName) 
	{
		this.imageFileName = imageFileName;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
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
