/*
 * CS 2110
 * Professor Graham
 * Homework 6
 * HW6Tests.java
 * Winston Zhang
 * 22 Oct 20
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class HW6Tests {

	//Constructor test
	@Test
	public void WillowTest() 
	{
		//Arguments used are taken straight from assignment example
		Willow w = new Willow("JPA", 2, true, 0.45, 1000.0);
		
		assertEquals("JPA", w.getNeighborhood());
		assertEquals(2, w.getBedrooms());
		assertTrue(w.getGarage());
		assertEquals(0.45, w.getDistToCenter(), 0.01);
		assertEquals(1000.0, w.getPrice(), 0.1);
	}
	
	//Default constructor test
	@Test
	public void WillowTest2()
	{
		Willow w = new Willow();
		
		assertEquals("", w.getNeighborhood());
		assertEquals(0, w.getBedrooms());
		assertFalse(w.getGarage());
		assertEquals(0.0, w.getDistToCenter(), 0.01);
		assertEquals(0.0, w.getPrice(), 0.1);
	}
	
	//Natural ordering test with only prices and distances
	@Test
	public void sortByNaturalOrderingTest()
	{
		ArrayList<Willow> exp = new ArrayList<Willow>();
		ArrayList<Willow> inp = new ArrayList<Willow>();
		
		/*
		 * a and b only differ in distance, and c differs from a only in price
		 * this means the expected order is a, b, c
		 */
		Willow a = new Willow("", 0, false, 5.0, 500.0);
		Willow b = new Willow("", 0, false, 7.0, 500.0);
		Willow c = new Willow("", 0, false, 5.0, 1000.0);
		
		exp.add(a);
		exp.add(b);
		exp.add(c);
		
		inp.add(b);
		inp.add(a);
		inp.add(c);
		
		a.sortByNaturalOrdering(inp);
		
		assertEquals(exp, inp);
	}
	
	//Natural order test with fully defined fields
	@Test
	public void sortByNaturalOrderingTest2()
	{
		ArrayList<Willow> exp = new ArrayList<Willow>();
		ArrayList<Willow> inp = new ArrayList<Willow>();
		
		/*
		 * for this sorting method, the expected order is b, a, c
		 */
		Willow a = new Willow("Neighborhood A", 3, true, 5.2, 1750.0);
		Willow b = new Willow("Neighborhood B", 2, false, 4.7, 770.50);
		Willow c = new Willow("Neighborhood C", 4, true, 17.9, 1750.0);
		
		exp.add(b);
		exp.add(a);
		exp.add(c);
		
		inp.add(c);
		inp.add(b);
		inp.add(a);
		
		a.sortByNaturalOrdering(inp);
		
		assertEquals(exp, inp);
	}
	
	//Bedroom and garage test with only bedrooms and garage fields defined
	@Test
	public void sortByBedroomsAndGarageTest()
	{
		ArrayList<Willow> exp = new ArrayList<Willow>();
		ArrayList<Willow> inp = new ArrayList<Willow>();
		
		/*
		 * a has more bedrooms than b and c, b has a garage
		 * the expected order here is a, b, c
		 */
		Willow a = new Willow("", 4, false, 0.0, 0.0);
		Willow b = new Willow("", 3, true , 0.0, 0.0);
		Willow c = new Willow("", 3, false, 0.0, 0.0);
		
		exp.add(a);
		exp.add(b);
		exp.add(c);
		
		inp.add(b);
		inp.add(a);
		inp.add(c);
		
		a.sortByBedroomsAndGarage(inp);
		
		assertEquals(exp, inp);
	}
	
	//Bedroom and garage sorting test with all fields defined
	@Test
	public void sortByBedroomsAndGarageTest2()
	{
		ArrayList<Willow> exp = new ArrayList<Willow>();
		ArrayList<Willow> inp = new ArrayList<Willow>();
		
		/*
		 * the expected order here is c, a, b
		 */
		Willow a = new Willow("Neighborhood A", 3, true, 5.2, 1750.0);
		Willow b = new Willow("Neighborhood B", 2, false, 4.7, 770.50);
		Willow c = new Willow("Neighborhood C", 4, true, 17.9, 1750.0);
		
		exp.add(c);
		exp.add(a);
		exp.add(b);
		
		inp.add(b);
		inp.add(a);
		inp.add(c);
		
		a.sortByBedroomsAndGarage(inp);
		
		assertEquals(exp, inp);
	}
	
	//Neighborhood and price sorting test with only neighborhood and price fields defined
	@Test
	public void sortByNeighborhoodAndPriceTest()
	{
		ArrayList<Willow> exp = new ArrayList<Willow>();
		ArrayList<Willow> inp = new ArrayList<Willow>();
			
		/*
		 * a and b are in the same neighborhood, but a is more expensive
		 * c is in a neighborhood with a name that is lower in the alphabet
		 * the expected order here is a, b, c
		 */
		Willow a = new Willow("Neighborhood A", 0, false, 0.0, 200.0);
		Willow b = new Willow("Neighborhood A", 0, false, 0.0, 100);
		Willow c = new Willow("Neighborhood B", 0, false, 0.0, 200.0);
		
		exp.add(a);
		exp.add(b);
		exp.add(c);
		
		inp.add(b);
		inp.add(a);
		inp.add(c);
		
		a.sortByNeighborhoodAndPrice(inp);
		
		assertEquals(exp, inp);
	}
	
	//Neighborhood and price sorting test with all fields defined
		@Test
		public void sortByNeighborhoodAndPriceTest2()
		{
			ArrayList<Willow> exp = new ArrayList<Willow>();
			ArrayList<Willow> inp = new ArrayList<Willow>();
				
			/*
			 * the expected order here is a, b, c
			 */
			Willow a = new Willow("Neighborhood A", 3, true, 5.2, 1750.0);
			Willow b = new Willow("Neighborhood B", 2, false, 4.7, 770.50);
			Willow c = new Willow("Neighborhood C", 4, true, 17.9, 1750.0);
			
			exp.add(a);
			exp.add(b);
			exp.add(c);
			
			inp.add(b);
			inp.add(a);
			inp.add(c);
			
			a.sortByNeighborhoodAndPrice(inp);
			
			assertEquals(exp, inp);
		}
	
}
