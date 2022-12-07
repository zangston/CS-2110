import static org.junit.Assert.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class FeedTest {

	Feed feed;
	
	@Before
	public void setup()
	{
		feed = new Feed();
	}
	
	@Test
	public void constructorTest()
	{
		ArrayList<Meme> memes = new ArrayList<Meme>();
		Feed feed = new Feed(memes);
		assertTrue("ArrayLists not equal", memes.equals(feed.getMemes()));
	}

	@Test
	public void setAndGetMemesTest()
	{
		ArrayList<Meme> memes = new ArrayList<Meme>();
		feed.setMemes(memes);
		assertTrue("ArrayLists not equal", memes.equals(feed.getMemes()));
	}
	
	@Test
	public void getNewMemeTest()
	{
		User u = new User();
		assertEquals("Memes can be returned", null, feed.getNewMeme(u));
		
		Meme m = new Meme();
		ArrayList<Meme> in = new ArrayList<Meme>();
		in.add(m);
		feed.setMemes(in);
		assertEquals("memes not equal", m, feed.getNewMeme(u));
	}
	
	@Test
	public void toStringTest()
	{
		String s = "";
		assertEquals("Invalid toString output", s, feed.toString());
		
		Meme meme = new Meme();
		Meme meme2 = new Meme();
		ArrayList<Meme> in = new ArrayList<Meme>();
		in.add(meme);
		in.add(meme2);
		feed.setMemes(in);
		
		String exp = meme.toString() + "\n" + meme2.toString() + "\n";
	
		assertEquals("Invalid toString output", exp, feed.toString());
	}
}
