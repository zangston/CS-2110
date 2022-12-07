/*
 CS 2110
 Winston Zhang (wyz5rge)
 September 8th, 2020
 */

public class PointsInAPlane {

	public static double points(double x, double y)
	{
		if(x >= 0 && y>= 0) //Returns product of x and y if they are both greater than or equal to 0
			return x * y;
		else if(x < 0 && y >= 0) //Returns difference between x and y if x is negative and y is zero or positive
			return x - y;
		else if(x < 0 && y < 0) //Returns quotient of x and y if they are both less than 0
			return x / y;
		else //Returns sum of x and y if neither of the above are satisfied
			return x + y;
	}
	
	public static void main(String[] arg)
	
	{
		System.out.println("x: 1.0 y: 2.0 \nThis should return 2.0");
		System.out.println(points(1, 2));
		
		System.out.println("\nx: 0.0 y: 1.0 \nThis should return 0.0");
		System.out.println(points(0, 2));
		
		System.out.println("\nx: -1.0 y: 0.0 \nThis should return -1.0");
		System.out.println(points(-1, 0));
		
		System.out.println("\nx: -1.0 y: 1.0 \nThis should return -2.0");
		System.out.println(points(-1, 1));
		
		System.out.println("\nx: 1.0 y: 0.0 \nThis should return 0.0");
		System.out.println(points(1, 0));
		
		System.out.println("\nx: -4.0 y: -1.0 \nThis should return 4.0");
		System.out.println(points(-4, -1));
		
		System.out.println("\nx: -1.0 y: -4.0 \nThis should return 0.25");
		System.out.println(points(-1, -4));
		
		System.out.println("\nx: 3.0 y: -1.0 \nThis should return 2.0");
		System.out.println(points(3, -1));
	}
}
