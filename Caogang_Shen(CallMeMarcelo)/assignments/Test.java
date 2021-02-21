public class Test {
    public static void main(String[] args) {
        Cat a = new Cat();
        System.out.println(a.i);
        // a.i = 2;
        // ((Animal) a).i = 1;
        Cat b = new Cat();
        System.out.println(((Animal)a).i + " " + a.i);
        System.out.println(((Animal)b).i + " " + b.i);
    }
    
}
class Animal {
    String i;

    // public Animal() {
    //     i = 5;
    //     System.out.println("a");
    // }
}
class Cat extends Animal {
    //int i = super.i;
    void meaw() {

    }
    void meaw(int i) {

    }
}
