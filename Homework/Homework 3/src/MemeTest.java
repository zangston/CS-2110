import static org.junit.Assert.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class MemeTest {

	Meme meme;
	
	@Before
	public void setup()
	{
		meme = new Meme();
	}
	
	@Test
	public void constructorTest() 
	{
		BackgroundImage b = new BackgroundImage();
		String caption = "";
		User u = new User();
		Meme meme = new Meme(b, caption, u);
		assertEquals("Background images not equal", b, meme.getBackgroundImage());
		assertEquals("Captions not equal", caption, meme.getCaption());
		assertEquals("Users not equal", u, meme.getCreator());
	}
	
	@Test
	public void setAndGetCreatorTest()
	{
		User u = new User();
		meme.setCreator(u);
		assertEquals("Users not equal", u, meme.getCreator());
	}

	@Test
	public void setAndGetBackgroundImageTest()
	{
		BackgroundImage b = new BackgroundImage();
		meme.setBackgroundImage(b);
		assertEquals("Background images not equal", b, meme.getBackgroundImage());
	}
	
	@Test
	public void setAndGetCaptionTest()
	{
		String caption = "";
		meme.setCaption(caption);
		assertEquals("Captions not equal", caption, meme.getCaption());
	}
	
	@Test
	public void setAndGetRatingsTest()
	{
		ArrayList<Rating> ratings = new ArrayList<>();
		meme.setRatings(ratings);
		assertTrue("ArrayLists not equal", meme.getRatings().equals(ratings));
	}
	
	@Test
	public void setAndGetSharedTest()
	{
		boolean shared = true;
		meme.setShared(shared);
		assertTrue("shared status invalid", meme.getShared());
	}
	
	@Test
	public void calculateRatingTest()
	{
		assertEquals("Doubles not equal", 0.0, meme.calculateRating(), 0.1);
		
		Rating rating = new Rating();
		rating.setScore(1);
		ArrayList<Rating> in = new ArrayList<Rating>();
		in.add(rating);
		
		meme.setRatings(in);
		
		assertEquals("Doubles not equal", 1.0, meme.calculateRating(), 0.1);
	}
	
	@Test
	public void toStringTest()
	{
		User u = new User("name");
		BackgroundImage b = new BackgroundImage("fileName", "title", "description");
		String c = "caption";
		Meme m = new Meme(b, c, u);
		
		Rating r1 = new Rating();
		r1.setRating(1);
		Rating r2 = new Rating();
		r2.setRating(-1);
		
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		ratings.add(r1);
		ratings.add(r2);
		
		m.setRatings(ratings);
		
		String s = m.getBackgroundImage().toString() + " '" + m.getCaption() + "' " + m.getCreator().getUserName() + " (" +
				m.getCreator().calculateReputation() + ") " + m.calculateRating() + " [(1) +1 (1) -1]";
		
		assertEquals("Incorrect toString output", s, m.toString());
		
	}
	
	@Test
	public void equalsTest()
	{
		User u = new User("name");
		BackgroundImage b = new BackgroundImage("fileName", "title", "description");
		String c = "caption";
		Meme m = new Meme(b, c, u);
		
		assertTrue("Memes not equal", m.equals(m));
		assertFalse("Memes are equal", m.equals(null));
		
		Object o = new Object();
		assertFalse("Objects are equal", m.equals(o));
		
		Meme m2 = new Meme(null, c, u);
		assertFalse("Background images are equal", m.equals(m2));
		assertFalse("Background images are equal", m2.equals(m));
		
		Meme m3 = new Meme(b, null, u);
		assertFalse("Captions are equal", m.equals(m3));
		assertFalse("Captions are equal", m3.equals(m));
		
		Meme m4 = new Meme(b, c, null);
		assertFalse("Creators are equal", m.equals(m4));
		assertFalse("Creators are equal", m4.equals(m));
		
		Meme m5 = new Meme(b, c, u);
		assertTrue("Memes not equal", m.equals(m5));
		
	}
}
