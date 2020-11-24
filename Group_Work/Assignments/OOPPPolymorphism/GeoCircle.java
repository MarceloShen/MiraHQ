package OOPPPolymorphism;
/**
 * The Circle class models a circle with a radius.
 */
// Should be "Circle.java" for GeometricObject but we can't have two
// Circle.java in the same folder to turn in
public class GeoCircle implements GeometricObject {
	// private instance variable, not accessible from outside this class
	protected double radius = 1.0;
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/** Constructs a Circle instance with the given radius */
	public GeoCircle(double r) { // 2nd constructor
		radius = r;
	}

	/** Returns the area of this Circle instance */
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
	@Override
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	@Override
	public String toString() {
		return "circle with radius = " + radius;
	}
}