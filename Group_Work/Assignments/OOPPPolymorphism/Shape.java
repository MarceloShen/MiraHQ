package OOPPPolymorphism;
public abstract class Shape {
    protected String color;
    protected boolean filled;
    
    public Shape() {
        color = "green";
        filled = true;
    }

    public Shape(String c, boolean f) {
        color = c;
        filled = f;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String c) {
        color = c;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean f) {
        filled = f;
    }

    public abstract double getPerimeter();

    public abstract double getArea();

    public String toString() {
        return "A shape with color of " + this.getColor() + " and " + (this.isFilled() ? "filled" : "not filled");
    }
}