package OOPPPolymorphism;

public class MovablePoint implements Movable { // saved as "MovablePoint.java"
	// instance variables
	int x, y, xSpeed, ySpeed; // package access

	// Constructor
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public String toString(){
		return "A point with x: " + this.x + " and y: " + this.y + ", with a speeds of (x, y): (" + this.xSpeed + ", " + this.ySpeed + ")";
	}

	// Implement abstract methods declared in the interface Movable
	@Override
	public void moveUp() {
		y -= ySpeed; // y-axis pointing down for 2D graphics
	}

	@Override
	public void moveDown() {
		y += ySpeed;
	}

	@Override
	public void moveLeft() {
		x -= xSpeed;
	}

	@Override
	public void moveRight() {
		x += xSpeed;
	}
}