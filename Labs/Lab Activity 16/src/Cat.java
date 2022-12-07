/**
 * 
 * @author CS 2110 Faculty
 * Cat class, subclass of Animal
 *
 */
public class Cat extends Animal {
	String breed;
	/** constructor */
	public Cat(String name) {
		super(name);
	}
	/** constructor */
	public Cat(String name, String breed) {
		super(name);
		this.breed = breed;
	}
	/** overridden makeNoise behavior */
	public String makeNoise() {
		return "Miaw!";
	}
}
