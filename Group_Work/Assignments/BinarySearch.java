public class BinarySearch {
    public static void main (String[] args) {
        int[] list = {1, 3, 6, 9, 15, 69, 420, 840};
        int target = 15;
        int mid = (list.length - 1) / 2;
        int left = 0;
        int right = list.length - 1;
        while (list[mid] != target) {
            if (list[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
            System.out.println(left + ", " + right);
        }
        System.out.println("Target: " + target + "\n" + "At Index: " + mid);
    }
}