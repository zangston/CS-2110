/**
 * 
 * @author CS 2110 Faculty
 * Dog subclass of Animal
 *
 */
public class Dog extends Animal {
	String breed;
	/** constructor */
	public Dog(String name) {
		super(name);
	}
	/** constructor */
	public Dog(String name, String breed) {
		super(name);
		this.breed = breed;
	}
	/** overridden makeNoise behavior */
	public String makeNoise() {
		return "Woof!";
	}
}
