/*
 * Winston Zhang, wyz5rge
 * CS 2110, Professor Graham
 * Lab Activity 7
 */

/*
 *  UML Diagram:
 *  Microwave
 *  -model : String
 *  -brand : String
 *  -serial : long
 *  -----------------------
 *  +cook(int seconds, String food) : void
 *  +defrost(int seconds, String food) : void
 *  +pop() : void
 */

import java.util.*;

public class Microwave {

	private String model;
	private String brand;
	private long serial;
	
	
	//Constructor methods
	public Microwave(String m, String b, long s)
	{
		this.model = m;
		this.brand = b;
		this.serial = s;
	}
	public Microwave() 
	{
		this.model = null;
		this.brand = null;
		this.serial = 0;
	}
	
	//Getter methods (I did not implement setter methods because it's not possible to change the model or serial number of a microwave)
	public String getModel()
	{
		return this.model;
	}
	public String getBrand()
	{
		return this.brand;
	}
	public long getSerial()	
	{
		return this.serial;
	}
	
	//toString method
	public String toString()
	{
		String s = "I am a " + brand + " brand " + model + " microwave. My serial number is: " + serial;
		return s;
	}
	
	//Functional (void) methods
	public void cook(int seconds, String food)
	{
		System.out.println("[" + seconds + " seconds pass...]");
		System.out.println("Your " + food + " has finished cooking. Enjoy your meal!");
	}
	
	public void defrost(int seconds, String food)
	{
		System.out.println("[" + seconds + " seconds pass...]");
		System.out.println("Your " + food + " has been defrosted.");
	}
	
	public void pop()
	{
		System.out.println("[180 seconds pass...]");
		System.out.println("Your popcorn is ready. Enjoy!");
	}
	
	//Main Method
	public static void main(String[] arg)
	{
		Microwave mike = new Microwave("Profile Countertop Convection", "GE", 254674951);
		
		Scanner input = new Scanner(System.in);
		
		int sel = -1;
		
		while(sel != 0)
		{
			System.out.println("\nPlease make one of the following selections: \n0) Close \n1) Heating \n2) Product Information");
			sel = input.nextInt();
		
			if(sel == 2)
				System.out.println(mike.toString());
			if(sel == 1)
			{
				System.out.println("What food would you like to cook?");
				String f = input.next();
			
				if(f.equalsIgnoreCase("popcorn"))
					mike.pop();
				else
				{
					System.out.println("Is it frozen?");
					String s = input.next();
				
					if(s.equalsIgnoreCase("yes"))
					{
						System.out.println("For how many seconds would you like to defrost your " + f + "?");
						int time = input.nextInt();
						mike.defrost(time, f);
					}
					if(s.equalsIgnoreCase("no"))
					{
						System.out.println("For how many seconds would you like to cook your " + f + "?");
						int time = input.nextInt();
						mike.cook(time, f);
					}
				}
			
			}
		}
		input.close();
	}
}
