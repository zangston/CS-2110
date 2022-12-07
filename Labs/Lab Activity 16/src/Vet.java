/**
 * 
 * @author CS 2110 Faculty
 * Vet class, where all domesticated animals must visit
 *
 */

import java.util.*;

public class Vet {

	// TODO The following method is incomplete; you need to fix it to:
	// a) take an animal argument and b) have the animal make its noise
	public static void giveShot(Animal a) {
		// do horrible things to the animal
		String animalType = String.valueOf(a.getClass()).substring(6);
		System.out.print(animalType + " " + a.name);
		System.out.print(" after the shot cried ");
		System.out.print(a.makeNoise() + "\n");
	}
	
	public static void main(String[] args) {
			
		// TODO Complete the rest of the code to print the following output:
		// > Dog Jack after the shot cried Woof!
		// > Cat Garfield after the shot cried Miaw!
		// > Animal Marlow after the shot cried ...
	
		Animal a = new Dog("Jack");
		Animal b = new Cat("Garfield");
		Animal c = new Animal("Marlow");
		
		/*
		Vet doctor = new Vet();
		doctor.giveShot(a);
		doctor.giveShot(b);
		doctor.giveShot(c);
		*/
		
		/*
		ArrayList<Dog> dogs1 = new ArrayList<Animal>();
		ArrayList<Animal> animals1 = new ArrayList<Dog>();
		
		ArrayList<Dog> dogs2 = new ArrayList<Dog>();
		ArrayList<Animal> animals = dogs2;
		
		ArrayList<Object> objs = new ArrayList<Dog>();
		
		*/
		
		
		//Animal dog = new Dog("");
		//Dog dog1 = new Animal("");
		
	}

}
