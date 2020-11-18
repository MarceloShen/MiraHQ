package ObjectOrientedProgramming;
public class Shape {
    private String color;
    private boolean filled;

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

    public String toString() {
        return "A shape with color of " + this.getColor() + " and " + (this.isFilled() ? "filled" : "not filled");
    }
}