/*
 * CS 2110
 * Professor Graham
 * Homework 6
 * Willow.java
 * Winston Zhang
 * 21 Oct 2020
 */

import java.util.*;

public class Willow implements Comparable<Willow>
{
	//Object instance variables
	private String neighborhood;
	private int bedrooms;
	private boolean garage;
	private double distToCenter;
	private double price;
	
	//Constructor that takes in all parameters
	public Willow(String n, int b, boolean g, double d, double p)
	{
		this.neighborhood = n;
		this.bedrooms = b;
		this.garage = g;
		this.distToCenter = d;
		this.price = p;
	}
	
	//Default constructor
	public Willow()
	{
		this.neighborhood = "";
		this.bedrooms = 0;
		this.garage = false;
		this.distToCenter = 0.0;
		this.price = 0.0;
	}
	
	//Getter methods for instance variables
	public String getNeighborhood()
	{
		return this.neighborhood;
	}
	public int getBedrooms()
	{
		return this.bedrooms;
	}
	public boolean getGarage()
	{
		return this.garage;
	}
	public double getDistToCenter()
	{
		return this.distToCenter;
	}
	public double getPrice()
	{
		return this.price;
	}

	//Setter methods for instance variables
		public void setNeighborhood(String n)
		{
			this.neighborhood = n;
		}
		public void setBedrooms(int b)
		{
			this.bedrooms = b;
		}
		public void setGarage(boolean g)
		{
			this.garage = g;
		}
		public void setDistToCenter(double d)
		{
			this.distToCenter = d;
		}
		public void setPrice(double p)
		{
			this.price = p;
		}

	
	//toString method
	public String toString()
	{
		String ret = "Neighborhood: " + this.getNeighborhood() + "\nBedrooms: " + this.getBedrooms() + "\nGarage: " +
				this.getGarage() + "\nDistance to Center of Campus: " + this.getDistToCenter() + "\nMonthly Price: " + this.getPrice();
		return ret;
	}
	
	//compareTo method for natural ordering (price and distance)
	public int compareTo(Willow o)
	{
		if(this.price < o.getPrice())
			return -1;
		else if(this.price > o.getPrice())
			return 1;
		
		if(this.distToCenter < o.getDistToCenter())
			return -1;
		else if(this.distToCenter > o.getDistToCenter())
			return 1;
		
		return 0;
	}
	
	//Sorting algorithm that uses the natural ordering, using the compareTo method
	public void sortByNaturalOrdering(ArrayList<Willow> list)
	{
		Collections.sort(list);
	}
	
	public static void sortByBedroomsAndGarage(ArrayList<Willow> list)
	{
		Collections.sort(list, new CmpByBedroomsAndGarage());
	}
	
	public static void sortByNeighborhoodAndPrice(ArrayList<Willow> list)
	{
		Collections.sort(list, new CmpByNeighborhoodAndPrice());
	}
}
