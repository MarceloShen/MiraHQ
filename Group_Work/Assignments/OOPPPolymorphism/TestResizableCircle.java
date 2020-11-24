package OOPPPolymorphism;

public class TestResizableCircle {
    public static void main(String args[]) {
        ResizableCircle rcircle = new ResizableCircle(100);
        System.out.println(rcircle); // Expected: "Resizable circle with radius = 100.0"
        rcircle.resize(120);
        System.out.println(rcircle); // Expected: "Resizable circle with radius = 120.0"
    }
}