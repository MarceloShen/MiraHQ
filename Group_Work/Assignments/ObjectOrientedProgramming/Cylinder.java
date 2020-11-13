package ObjectOrientedProgramming;
public class Cylinder extends Circle { // Save as "Cylinder.java"
	private double height; // private variable

	// Constructor with default color, radius and height
	public Cylinder() {
		//		TO DO: // call superclass no-arg constructor Circle()
		super();
		height = 1.0;
	}

	// Constructor with default radius, color but given height
	public Cylinder(double height) {
		//		TO DO: // call superclass no-arg constructor Circle()
		super();
		this.height = height;
	}

	// Constructor with default color, but given radius, height
	public Cylinder(double radius, double height) {
		//		TO DO: // call superclass constructor Circle(r)
		super(radius);
		this.height = height;
	}

	// A public method for retrieving the height
	public double getHeight() {
		return height;
	}

	// A public method for computing the volume of cylinder
	// use superclass method getArea() to get the base area
	public double getVolume() {
		//		TO DO:
		return super.getArea() * height;
	}

	//	TO DO: toString() method to the Cylinder class, which 
	//	overrides the toString() inherited from the superclass Circle
	@Override
	public String toString() {
		return "A cylinder with radius="+ this.getRadius() + " and height=" + this.getHeight();
	}

	@Override
	public double getArea() {
		return 2 * super.getArea() + 2 * Math.PI * this.getRadius() * this.getHeight();
	}
}
