public class Octahedron implements Solids{
	
	private double edge;
	private String color, name;
	
	public Octahedron(double edge, String color, String name){
		this.edge = edge;
		this.color = color;
		this.name = name;
	}
	
	// Volume= [(square root of 2)/3]  * edge^3  [Note: edge^3 is edge-cubed]
	public double getVolume(){
		//TODO: complete this method (based on the formula above)
		double re = (Math.sqrt(2) / 3) * (Math.pow(this.edge, 3));
		return re;
	}
	
	public String getColor(){
		//TODO: complete this method
		return this.color;
	}
	
	public String getName(){
		//TODO: complete this method
		return this.name;
	}

}