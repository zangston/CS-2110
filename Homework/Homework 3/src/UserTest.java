import static org.junit.Assert.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	User user;
	
	@Before
	public void setup()
	{
		user = new User();
	}
	
	@Test
	public void constructorTest()
	{
		User user = new User("name");
		ArrayList<Meme> createdExp = new ArrayList<Meme>();
		ArrayList<Meme> viewedExp = new ArrayList<Meme>();
		assertEquals("Invalid username returned", "name", user.getUserName());
		assertEquals("ArrayLists not equal", createdExp, user.getMemesCreated());
		assertEquals("ArrayLists not equal", viewedExp, user.getMemesViewed());
	}

	@Test
	public void setAndGetUserNameTest()
	{
		user.setUserName("name");
		assertEquals("Invalid name returned", "name", user.getUserName());
	}
	@Test
	public void setAndGetMemesCreatedTest()
	{
		ArrayList<Meme> exp = new ArrayList<Meme>();
		user.setMemesCreated(exp);
		assertEquals("ArrayLists not equal", exp, user.getMemesCreated());
	}
	@Test
	public void setAndGetMemesViewedTest()
	{
		ArrayList<Meme> exp = new ArrayList<Meme>();
		user.setMemesViewed(exp);
		assertEquals("ArrayLists not equal", exp, user.getMemesViewed());
	}
	
	@Test
	public void createMemeTest()
	{
		BackgroundImage b = new BackgroundImage("file name", "title", "description");
		String caption = "caption";
		Meme exp = new Meme(b, caption, user);
		assertEquals("Memes not equal", exp, user.createMeme(b, caption));
	}
	
	@Test
	public void deleteMemeTest()
	{
		BackgroundImage b = new BackgroundImage("file name", "title", "description");
		String caption = "caption";
		Meme m = new Meme();
		m = user.createMeme(b, caption);
		ArrayList<Meme> exp = new ArrayList<Meme>();
		user.deleteMeme(m);
		assertEquals("ArrayLists not equal", exp, user.getMemesCreated());
	}
	
	@Test
	public void shareMemeTest()
	{
		Feed f = new Feed();
		Meme m = new Meme();
		user.shareMeme(m, f);
		assertTrue("Meme was not shared", m.getShared());
	}
	
	//test for rateNextMeme, passed in a positive value
	@Test
	public void rateNextMemeTest()
	{
		Feed f = new Feed();
		Meme m = new Meme();
		ArrayList<Meme> in = new ArrayList<Meme>();
		in.add(m);
		f.setMemes(in);
		user.rateNextMeme(f, 1);
		assertEquals("Ratings not equal", 1, (int)m.calculateRating());
	}
	//test case for 0 rating
	@Test
	public void rateNextMemeTest2()
	{
		Feed f = new Feed();
		Meme m = new Meme();
		ArrayList<Meme> in = new ArrayList<Meme>();
		in.add(m);
		f.setMemes(in);
		user.rateNextMeme(f, 0);
		assertEquals("Ratings not equal", 0, (int)m.calculateRating());
	}
	//test case for negative rating
	@Test
	public void rateNextMemeTest3()
	{
		Feed f = new Feed();
		Meme m = new Meme();
		ArrayList<Meme> in = new ArrayList<Meme>();
		in.add(m);
		f.setMemes(in);
		user.rateNextMeme(f, -1);
		assertEquals("Ratings not equal", -1, (int)m.calculateRating());
	}
	//test case for an empty feed
	@Test
	public void rateNextMemeTest4()
	{
		Feed f = new Feed();
		ArrayList<Meme> empty = new ArrayList<Meme>();
		user.rateNextMeme(f, 0);
		assertEquals("No memes", empty, f.getMemes());
	}
	
	//test for user that has created memes
	@Test
	public void calculateReputationTest2()
	{
		BackgroundImage b = new BackgroundImage();
		String caption = "";
		Meme m = new Meme();
		m =	user.createMeme(b, caption);
		assertEquals("Doubles not equal", 0.0, user.calculateReputation(), 0.01);
		
		user.deleteMeme(m);
		assertEquals("Doubles not equal", 0.0, user.calculateReputation(), 0.01);
	}
	
	@Test
	public void toStringTest()
	{
		user.setUserName("name");
		String s = "name has rated (0) memes, (0.0)";
		assertEquals("Invalid toString", s, user.toString());
	}
	
	@Test
	public void equalsTest()
	{
		User u1 = new User("name");
		assertTrue("Users not equal", u1.equals(u1));
		assertFalse("Users are equal", u1.equals(null));
		
		Object o = new Object();
		assertFalse("Objects are equal", u1.equals(o));
		
		User u2 = new User(null);
		assertFalse("Users are equal", u2.equals(u1));
		assertFalse("Users are equal", u1.equals(u2));
		
		u2.setUserName("name");
		assertTrue("Users are not equal", u1.equals(u2));
	}
}
