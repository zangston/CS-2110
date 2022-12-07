/**
 * 
 * @author CS 2110 Faculty
 * Animal Superclass
 *
 */
public class Animal {
	String name;
	/** constructor accepting a String for name */
	public Animal(String name) {
		this.name = name;
	}
	/** a behavior of all Animals represented by this class */
	public String makeNoise() {
		return "...";
	}

}
