package OOPPPolymorphism;

public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(){
        super();
        width = 1.0;
        length = 1.0;
    }
    public Rectangle(double width, double length){
        super();
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }


    public double getWidth() {
        return this.width;
    }
    
    public void setWidth(double w) {
        this.width = w;
    }
    
    public double getLength() {
        return this.length;
    }
    
    public void setLength(double h){
        this.length = h;
    }
    
    @Override
    public double getArea() {
        return this.width * this.length;
    }

    @Override
    public double getPerimeter() {
        return 2.0 * (this.width + this.length); 
    }

    @Override
    public String toString(){
        return "A Rectangle with width=" + this.getWidth() + " and length=" + this.getLength() + ", which is a subclass of " + super.toString();
    }

}
