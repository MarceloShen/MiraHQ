package OOPPPolymorphism;
public class Square extends Rectangle {

    public Square() {
        super();
    }
    
    public Square(double side) {
        super(side, side);
        
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return super.getLength();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    
    @Override
    public void setWidth(double s){
        this.setSide(s);
    }

    @Override
    public void setLength(double s){
        this.setSide(s);
    }

    @Override
    public String toString() {
        return "A Square with side length=" + this.getSide() + ", which is a subclass of " + super.toString();
    }
}
