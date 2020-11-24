package OOPPPolymorphism;

public class MovableRectangle implements Movable { // saved as "MovableCircle.java"
    // instance variables
    private MovablePoint topLeft;
    private MovablePoint bottomRight;
    
    // Constructor
    public MovableRectangle(int x, int y, int xSpeed, int ySpeed, int length, int width) {
        // Call the MovablePoint's constructor
        topLeft = new MovablePoint(x, y, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x + length, y + width, xSpeed, ySpeed);
    }
    
    
    // Implement abstract methods declared in the interface Movable
    @Override
    public void moveUp() {
        topLeft.y -= topLeft.ySpeed;
        bottomRight.y -= bottomRight.ySpeed;
    }
    @Override
    public void moveDown() {
        topLeft.y += topLeft.ySpeed;
        bottomRight.y += bottomRight.ySpeed;
    }
    @Override
    public void moveLeft() {
        topLeft.x -= topLeft.xSpeed;
        bottomRight.x -= bottomRight.xSpeed;
    }
    @Override
    public void moveRight() {
        topLeft.x += topLeft.xSpeed;
        bottomRight.x += bottomRight.xSpeed;
    }
    
    public String toString(){
        return "A Rectangle with top left x: " + topLeft.x + ", y: " + topLeft.y + ", and bottom right x: " + bottomRight.x + ", y: " + bottomRight.y + ", with speeds of (x, y): (" + topLeft.xSpeed + ", " + topLeft.ySpeed + ")";
    }
}