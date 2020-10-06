public class Recursion {
    public static void main(String[] args) {
        System.out.println(recursiveSum(5));
    }

    public static recursiveSum(int n) {
        if (n <= 1) {
            return n;
        } else {
            return (n + recursiveSum(n - 1));
        }
    }
}
