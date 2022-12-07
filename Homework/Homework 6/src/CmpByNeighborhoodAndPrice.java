/*
 * CS 2110
 * Professor Graham
 * Homework 6
 * CmpByBedroomsAndGarage.java
 * Winston Zhang
 * 22 Oct 20
 */

import java.util.*;

public class CmpByNeighborhoodAndPrice implements Comparator<Willow>
{
	public int compare(Willow w1, Willow w2)
	{
		if(w1.getNeighborhood().compareTo(w2.getNeighborhood()) != 0)
			return w1.getNeighborhood().compareTo(w2.getNeighborhood());
		
		if(w1.getPrice() > w2.getPrice())
			return -1;
		else if(w1.getPrice() < w2.getPrice())
			return 1;
		
		return 0;
	}
}
