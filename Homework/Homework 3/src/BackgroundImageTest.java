import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BackgroundImageTest
{	
	
	BackgroundImage pic;
	
	@Before
	public void setup()
	{
		pic = new BackgroundImage();
	}
	
	@Test
	public void constructorTest()
	{
		BackgroundImage pic = new BackgroundImage("file name", "title", "description");
		assertEquals("Invalid file name returned", "file name", pic.getImageFileName());
		assertEquals("Invalid title returned", "title", pic.getTitle());
		assertEquals("Invalid description returned", "description", pic.getDescription());
	}

	@Test
	public void setAndGetImageFileNameTest()
	{
		String s = "file name";
		pic.setImageFileName(s);
		assertEquals("Invalid String returned", "file name", pic.getImageFileName());
	}

	@Test
	public void setAndGetTitleTest() 
	{
		String s = "title";
		pic.setTitle(s);
		assertEquals("Invalid String returned", "title", pic.getTitle());
	}
	
	@Test
	public void setAndGetDescriptionTest()
	{
		String s = "description";
		pic.setDescription(s);
		assertEquals("Invalid String returned", "description", pic.getDescription());
	}
	
	@Test
	public void toStringTest()
	{
		pic.setTitle("title");
		pic.setDescription("description");
		String exp = "title <description>";
		assertEquals("Invalid toString returned", exp, pic.toString());
	}
	
	//equals test for two separate BackgroundImage objects with equivalent fields
	@Test
	public void equalsTest()
	{
		BackgroundImage a = new BackgroundImage("file name", "title", "description");
		BackgroundImage b = new BackgroundImage("file name", "title", "description");
		assertTrue("Objects not equal", a.equals(b));
	}
	//equals test for two separate separate objects
	@Test
	public void equalsTest2()
	{
		BackgroundImage a = new BackgroundImage("file name", "title", "description");
		Object b = new Object();
		assertFalse("Objects are equal", a.equals(b));
	}
	//equals test for Background image object and null
	@Test
	public void equalsTest3()
	{
		BackgroundImage a = new BackgroundImage("file name", "title", "description");
		assertFalse("Objects are equal", a.equals(null));
	}
	//equals test for Background image and itself
	@Test
	public void equalsTest4()
	{
		BackgroundImage a = new BackgroundImage("file name", "title", "description");
		assertTrue("Objects are not equal", a.equals(a));
	}
	//equals test for null description field
	@Test
	public void equalstTest5()
	{
		BackgroundImage a = new BackgroundImage("file name", "title", "description");
		BackgroundImage b = new BackgroundImage("file name", "title", null);
		assertFalse("Objects are equal", a.equals(b));
		assertFalse("Objects are equal", b.equals(a));
	}
	//equals test for null title field
	@Test
	public void equalsTest6()
	{
		BackgroundImage a = new BackgroundImage("file name", "title", "description");
		BackgroundImage b = new BackgroundImage("file name", null, "description");
		assertFalse("Objects are equal", a.equals(b));
		assertFalse("Objects are equal", b.equals(a));
	}
	//equals test for null file name field
	@Test
	public void equalsTest7()
	{
		BackgroundImage a = new BackgroundImage("file name", "title", "description");
		BackgroundImage b = new BackgroundImage(null, "title", "description");
		assertFalse("Objects are equal", a.equals(b));
		assertFalse("Objects are equal", b.equals(a));
	}
}
