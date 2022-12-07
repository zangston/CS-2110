/*
 * Winston Zhang, wyz5rge
 * CS 2110, Professor Graham
 * Lab Activity 8
 * September 16, 2020
 */

public class Rectangle {
	
	// fields
	private double length;
	private double width;
	
	// default constructor (takes no parameters)
	public Rectangle() {
		// length and width assigned default values (4 for length and 2 for width)
		this.length = 4;
		this.width = 2;
	}
	
	// constructor 
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	// WRITE an appropriate 
	//     (1) toString method
	//     (2) getter and setter methods for the length field
	//     (3) getter and setter methods for the width field 
	
	public String toString()
	{
		return "Length: " + length + "\nWidth: " + width;
	}
	
	public double getLength()
	{
		return length;
	}
	public double getWidth()
	{
		return width;
	}
	
	public void setLength(double l)
	{
		length = l;
	}
	public void setWidth(double w)
	{
		width = w;
	}
	
	
	public static void main(String[] args) {
		// Reminder: don't write methods within other methods.
		// Test out toString() method and getters and setters here! (Main method testing) 
		
		Rectangle alpha = new Rectangle(7.2, 8.3);
		System.out.println("My length is " + alpha.getLength() + " and my width is " + alpha.getWidth());
		System.out.println("This is what my toString method returns: \n" + alpha.toString());
		
		System.out.println("\nI am now going to change my sides to random lengths to test my setter methods...");
		double x = Math.random() * 100;
		double y = Math.random() * 100;
		alpha.setLength(x);
		alpha.setWidth(y);
		System.out.println("\nMy length is " + alpha.getLength() + " and my width is " + alpha.getWidth());
		System.out.println("This is what my toString method returns: \n" + alpha.toString());
		
		Rectangle beta = new Rectangle();
		System.out.println("\nI am a separate rectangle who exists to test if my default constructor works.");
		System.out.println("My length is " + beta.getLength() + " and my width is " + beta.getWidth());
		System.out.println("This is what my toString method returns: \n" + beta.toString());
	}

}