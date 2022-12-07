import static org.junit.Assert.*;

import org.junit.Test;

public class InClass13Test {

	/* Covers power method's first block of code that should execute if
	 * 0 is passed in as a base and a negative number is passed in as a power
	 */
	@Test
	public void powerTest() {
		assertEquals("Wrong value returned", Double.NaN, InClass13.power(0.0, -1), 0.01);
	}

	/* Covers power method's while loop that normally raises a value to a power
	 * it should execute when any number is passed in as a base a positive number is passed in as a power
	 */
	@Test
	public void powerTest2()
	{
		assertEquals("Wrong value returned", 1024.0, InClass13.power(2.0, 10), 0.01);
	}
	
	/* Covers last block of code in power method that should execute if
	 * a negative number is passed in as a power
	 */
	@Test
	public void powerTest3()
	{
		assertEquals("Wrong value returned", 1/1024.0, InClass13.power(2.0, -10), 0.01);
	}
}
