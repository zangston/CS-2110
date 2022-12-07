/**
 * In class activity for day 13.
 * 
 * Write 3 JUnit tests to get 100% statement coverage
 *
 * @author CS 2110 Instructors
 *
 */
public class InClass13 {
	/**
	 * power method
	 * @param base - the base number to use
	 * @param exp - what power to raise the base
	 * @return the base raised to the power value
	 */
	public static double power(double base, int exp) {
		/* evaluate the expression ( exp <= 0 )
		* assign that to the negExp variable
		* we'll calculate positive and negative exponents the same,
		* but for negative exponents, we return the reciprocal
		*/
		boolean negExp = (exp <= 0) ? true : false; 
		// protect against invalid input
		if (base == 0 && negExp) {
			return Double.NaN; // Double.NaN is a static value indicating Not a Number
		}
		exp = Math.abs(exp);
		double product = 1.0;
		while (exp > 0) {
			product *= base;
			exp--;
		} 
		if (negExp) {
			// for negative exponents, return the reciprocal value
			return 1 / product;
		} else {
			return product;
		}
	}
}