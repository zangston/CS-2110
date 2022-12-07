public class Sphere implements Solids {
	
	private double radius;
	private String color, name;
	
	public Sphere(double radius, String color, String name){
		this.radius = radius;
		this.color = color;
		this.name = name;
	}
	
	//Volume = 4/3*pi*r^3
	public double getVolume(){
		//TODO: complete this method (based on the formula above)
		double c = (4.0 / 3.0) * Math.PI;
		double re = c * Math.pow(this.radius, 3);
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