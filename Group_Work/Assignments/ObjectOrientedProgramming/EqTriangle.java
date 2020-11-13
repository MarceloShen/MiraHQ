package ObjectOrientedProgramming;

// Equilateral Triangle
public class EqTriangle extends Shape {
    private double length;

    public EqTriangle() {
        super();
    }

    public EqTriangle(double length) {
        super();
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }
    public void setLength(double l) {
        this.length = l;
    }

    public double getPerimeter() {
        return this.getLength() * 3;
    }

    public double getAngleDegrees() {
        return 60.0;
    }

    public double getAngleRadians() {
        return Math.PI / 3;
    }

    public double getArea() {
        return length * length * Math.sqrt(3) / 4;
    }

    @Override
    public String toString() {
        return "A Equilateral Triangle with sidelength=" + this.getLength() + ", which is a subclass of " + super.toString();
    }
}
