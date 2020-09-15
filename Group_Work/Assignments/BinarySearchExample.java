public class BinarySearchExample {
    public static void main (String[] args) {
        int[] array = {1, 2, 4, 6, 8};
        int target = 6;
        int mid = (array.length - 1) / 2;
        int low = 0;
        int high = array.length - 1;
        while (array[mid] != target) {
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
            System.out.println(low + ", " + high);
        }
        System.out.println("Target: " + target + "\n" + "At Index: " + mid);
    }
}