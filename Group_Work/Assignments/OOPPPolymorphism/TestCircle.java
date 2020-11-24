package OOPPPolymorphism;

public class TestCircle {
    public static void main(String args[]) {
        GeometricObject circle = new GeoCircle(10);
        // should return 100*pi
        System.out.println(circle.getArea());
        // should return 20*pi
        System.out.println(circle.getPerimeter());
        // should return "circle with radius = 10.0"
        System.out.println(circle.toString());
    }
}