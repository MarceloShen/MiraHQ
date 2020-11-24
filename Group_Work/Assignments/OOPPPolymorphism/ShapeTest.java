package OOPPPolymorphism;
/*
 * Tester class for Circle, Rectangle, and Square classes.
 * 
 * Question: What is the usage of the abstract method and abstract class?
 *
 * Abstraction is used in order to hide details in order to only show essential information
 * to the user, by hiding the implementation details and providing the functionality.
 * Abstract methods are also used in order to show that a class should contain a specific
 * method, but the implementation of the method should be put in the subclasses.
 */
public class ShapeTest {

	public static void main(String[] args) {
		Shape s1 = new Circle(5.5, "red", false);  // Upcast Circle to Shape
		System.out.println(s1);                    // which version?
		System.out.println(s1.getArea());          // which version?
		System.out.println(s1.getPerimeter());     // which version?
		System.out.println(s1.getColor());
		System.out.println(s1.isFilled());
		// System.out.println(s1.getRadius());
		/* 
		 *  getRadius() is a method for Circle objects. The above line triggers a compilation error
		 *  because at compile time, the compiler evaluates s1 as its static type, Shape, and Shape
		 *  does not have a getRadius() method.
		 */
		
		   
		Circle c1 = (Circle)s1;                   // Downcast back to Circle
		System.out.println(c1);
		System.out.println(c1.getArea());
		System.out.println(c1.getPerimeter());
		System.out.println(c1.getColor());
		System.out.println(c1.isFilled());
		System.out.println(c1.getRadius());
		   
		// Shape s2 = new Shape();
		/**
		 * Shape cannot be instantiated because it is an abstract class.
		 */
		   
		Shape s3 = new Rectangle(1.0, 2.0, "red", false);   // Upcast
		System.out.println(s3);
		System.out.println(s3.getArea());
		System.out.println(s3.getPerimeter());
		System.out.println(s3.getColor());
		// System.out.println(s3.getLength());
		/*	getLength() is a method for Rectangle objects. The above line triggers a compilation error
		 *  because at compile time, the compiler evaluates s1 as its static type, Shape, and Shape
		 *  does not have a getLength() method.
		 */
		   
		Rectangle r1 = (Rectangle)s3;   // downcast
		System.out.println(r1);
		System.out.println(r1.getArea());
		System.out.println(r1.getColor());
		System.out.println(r1.getLength());
		   
		Shape s4 = new Square(6.6);     // Upcast
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		/*System.out.println(s4.getSide());
		* In this case, s4 is a Square, but has been downcasted
		* into a Shape object. Since Shape doesn't have the getSide method
		* it comes up as an error.
		*/
		  
		// Take note that we downcast Shape s4 to Rectangle, 
		//  which is a superclass of Square, instead of Square
		Rectangle r2 = (Rectangle)s4;
		System.out.println(r2);
		System.out.println(r2.getArea());
		System.out.println(r2.getColor());
		/* System.out.println(r2.getSide());
		* Rectange doesn't have the getSide method in its class
		* That is a Square function, Rectangle doesn't have all the methods
		* that it's children Square class has, which is why an error occurs when
		* you run this
		*/
		System.out.println(r2.getLength());
		   
		// Downcast Rectangle r2 to Square
		Square sq1 = (Square)r2;
		System.out.println(sq1);
		System.out.println(sq1.getArea());
		System.out.println(sq1.getColor());
		System.out.println(sq1.getSide());
		System.out.println(sq1.getLength());

	}

}
