/*
 * Winston Zhang (wyz5rge)
 * CS 2110, Professor Graham
 * Lab Activity 9
 * Circle.java
 */

public class Circle {

	private Point p;
	private double radius;
	
	public Circle(Point c, double rad){
		p = c;
		radius = rad;
	}
	
	public Circle(){
		p = new Point(0,0);
		radius = 1;
	}
	
	
	
	public static void main(String[] args) {
	
		Point p = new Point(1,1);
		Circle c = new Circle(p, 3);
		System.out.println(c);
		
		String s = "3.1415";
		double pi = Double.parseDouble(s);
		System.out.println(pi * 5);
		
		//Main method testing
		//This block of code compares two references to the same circle
		Point p1 = new Point(0,0);
		Circle c1 = new Circle(p1, 4);
		Circle c2 = c1;
		System.out.println("\nThis should return true: " + c1.equals(c2));
		
		//This block of code compares two separate circle objects with same values
		Point p2 = new Point(5,6);
		Circle c3 = new Circle(p2, 3);
		Circle c4 = new Circle(p2, 3);
		System.out.println("\nThis should return true: " + c3.equals(c4));
		
		//This block of code compares two separate circles with different values
		Point p3 = new Point(4, 2);
		Point p4 = new Point(3, 5);
		Circle c5 = new Circle(p3, 9);
		Circle c6 = new Circle(p4, 15);
		System.out.println("\nThis should return false: " + c5.equals(c6));
	}
	
	@Override
	public String toString(){
		return "<" + p + ", " + "radius: " + radius +">";
	}
	
	
	//Overrides Object equals method to check if two objects are circles with equal values
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	
}