package polymorphism;

public class MovablePoint implements Movable { // saved as "MovablePoint.java"
	   // instance variables
	   int x, y, xSpeed, ySpeed;     // package access
	   
	   // Constructor
	   public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
	      this.x = x;
	   // ......
	   }
	   //......
	   
	   // Implement abstract methods declared in the interface Movable
	   @Override
	   public void moveUp() {
	      y -= ySpeed;   // y-axis pointing down for 2D graphics
	   }
	   //......
	}