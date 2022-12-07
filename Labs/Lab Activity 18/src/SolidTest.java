import java.util.ArrayList;

public class SolidTest {

	public static void main(String[] args) {
		
		Cuboid c = new Cuboid(3, 4, 5, "Blue", "Cuboid");
		Sphere s = new Sphere(5, "Red", "Sphere");
		Octahedron o = new Octahedron(6, "Green", "Octahedron");
		Pyramid p = new Pyramid(1, 5, 7, "Yellow","Pyramid");
		
		ArrayList<Solids> sol = new ArrayList<Solids>();
		sol.add(c);
		sol.add(s);
		sol.add(o);
		sol.add(p);
		
		for(Solids so: sol){
			System.out.println(so.getName() + " Volume: " + so.getVolume()
						+ " Color: " + so.getColor());
		}

	}

}