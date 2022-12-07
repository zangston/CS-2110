/*
 * CS 2110
 * Professor Graham
 * Homework 6
 * CmpByBedroomsAndGarage.java
 * Winston Zhang
 * 22 Oct 20
 */

import java.util.*;

public class CmpByBedroomsAndGarage implements Comparator<Willow>
{
	public int compare(Willow w1, Willow w2)
	{
		if(w1.getBedrooms() > w2.getBedrooms())
			return -1;
		else if(w1.getBedrooms() < w2.getBedrooms())
			return 1;
		
		if(w1.getGarage() && !w2.getGarage())
			return -1;
		else if(!w1.getGarage() && w2.getGarage())
			return 1;
		
		return 0;
	}
}
