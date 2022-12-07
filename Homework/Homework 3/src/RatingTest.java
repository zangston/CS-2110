import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RatingTest {

	Rating rating;
	
	@Before
	public void setup()
	{
		rating = new Rating();
	}
	
	@Test
	public void constructorTest() 
	{
		User u = new User();
		Rating rating = new Rating(u, 0);
		assertEquals("Users not equal", u, rating.getUser());
		assertEquals("scores not equal", 0, rating.getScore());
	}
	
	@Test
	public void setAndGetScoreTest()
	{
		rating.setScore(1);
		assertEquals("Score not correct", 1, rating.getScore());
		
		rating.setScore(-1);
		assertEquals("Score not correct", -1, rating.getScore());
		
		rating.setScore(0);
		assertEquals("Score not correct", 0, rating.getScore());
	}

	@Test
	public void setAndGetUserTest()
	{
		User u = new User();
		rating.setUser(u);
		assertEquals("Users not equal", u, rating.getUser());
	}
	
	@Test
	public void setRatingTest()
	{
		rating.setRating(1);
		assertEquals("Score not correct", 1, rating.getScore());
		
		rating.setRating(-1);
		assertEquals("Score not correct", -1, rating.getScore());
		
		rating.setRating(0);
		assertEquals("Score not correct", 0, rating.getScore());
	}
	
	@Test
	public void toStringTest()
	{
		User user = new User("name");
		Rating rating = new Rating(user, 0);
		String s = rating.getUser().getUserName() + " rates 0";
		assertEquals("Incorrect toString output", s, rating.toString());
	}
	
	@Test
	public void equalsTest()
	{
		User user = new User("name");
		Rating rating = new Rating(user, 0);
		
		assertTrue("Ratings not equal", rating.equals(rating));
		assertFalse("Ratings are equal", rating.equals(null));
		
		Object o = new Object();
		assertFalse("Objects are equal", rating.equals(o));
		
		Rating rating2 = new Rating(user , 1);
		assertFalse("Ratings are equal", rating.equals(rating2));
		
		Rating rating3 = new Rating(null, 0);
		assertFalse("Ratings are equal", rating.equals(rating3));
		assertFalse("Ratings are equal", rating3.equals(rating));
		
		Rating rating4 = new Rating(user, 0);
		assertTrue("Ratings are not equal", rating.equals(rating4));
	}
}
