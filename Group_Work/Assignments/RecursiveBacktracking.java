import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Recursive Backtracking Example Methods
 * 
 * @author Marcelo Shen, Ashley Mead, Eashver Elango, (Brandon Yi) 
 */
public class RecursiveBacktracking {

    /**
     * Test Cases
     * 
     * @param args command-line arguments we don't use in the tests
     */
    public static void main(String[] args) {
        travel(2, 2);
        countBinary(3);
        List<Integer> L = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(maxSum(L, 8));
        System.out.println(partitionable(L));

        System.exit(0);
    }

    // ------------------------------------Travel------------------------------------------------------//

    /**
     * This method prints out all the possible routes to go to (x, y) from the
     * origin. Calls the travelHelper() method with given params. O(n) space; O(2^n)
     * time.
     * 
     * @param x horizontal distance to move
     * @param y vertical distance to move
     */
    public static void travel(int x, int y) {
        StringBuilder currentString = new StringBuilder();
        travelHelper(x, y, currentString);
    }

    /**
     * Base Case is where x <= 0 || y <= 0. Recursive Case is anything else.
     * 
     * @param x             horizontal distance to move
     * @param y             vertical distance to move
     * @param currentString the current route, using N - North, E - East, NE -
     *                      Northeast
     */
    private static void travelHelper(int x, int y, StringBuilder currentString) {
        // base case
        if (x <= 0 && y <= 0) {
            System.out.println(currentString.toString());
            return;
        }

        // Horizontal calculations based on x
        if (x > 0) {
            currentString.append("E ");
            // Case where you move 1 unit less far horizontally
            travelHelper(x - 1, y, currentString);
            // Remove the redundant character from the previous level
            currentString.delete(currentString.length() - 2, currentString.length());
        }

        // Vertical calculations based on y
        if (y > 0) {
            currentString.append("N ");
            // Case where you move 1 unit less far vertically
            travelHelper(x, y - 1, currentString);
            // Remove the redundant character from the previous level
            currentString.delete(currentString.length() - 2, currentString.length());
        }

        // Diagonal calculations based on x and y
        if (x > 0 && y > 0) {
            currentString.append("NE ");
            // Case where you move 1 unit less far diagonally
            travelHelper(x - 1, y - 1, currentString);
            // Remove the redundant character from the previous level
            currentString.delete(currentString.length() - 3, currentString.length());
        }

        return;
    }

    // ----------------------------------CountBinary------------------------------------------------------//

    /**
     * This method prints all binary numbers that have n digits in ascending order,
     * printing each value on a separate line. Calls the countBinaryHelper() method
     * with the given params. O(n) space; O(2^n) time.
     * 
     * @param n the number of digits for each binary number
     */
    public static void countBinary(int n) {
        StringBuilder currentString = new StringBuilder();
        countBinaryHelper(n, currentString);
    }

    /**
     * The helper function for countBinary
     * 
     * @param n             the number of digits for each binary number
     * @param currentString the current subcase
     */
    private static void countBinaryHelper(int n, StringBuilder currentString) {
        // base case
        if (n <= 0) {
            System.out.println(currentString.toString());
            return;
        }

        // Append 0 case
        currentString.append("0");
        countBinaryHelper(n - 1, currentString);
        // Remove the redundant character from the previous level
        currentString.deleteCharAt(currentString.length() - 1);

        // Append 1 case
        currentString.append("1");
        countBinaryHelper(n - 1, currentString);
        // Remove the redundant character from the previous level
        currentString.deleteCharAt(currentString.length() - 1);

        return;
    }

    // ----------------------------------MaxSum------------------------------------------------------//

    /**
     * This method returns an integer that indicates the maximum sum from the list
     * of integers in L without exceeding the limit of n. Calls the maxSumHelper
     * method with the given params. O(n) space, O(2^n) time.
     * 
     * @param L List of integers
     * @param n Limit that the maximum sum cannot exceed
     * @return The maximum possible sum of integers in the list
     */
    public static int maxSum(List<Integer> L, int n) {
        return maxSumHelper(L, n, 0, 0);
    }

    /**
     * The helper function for maxSum
     * 
     * @param L          List of integers
     * @param n          Limit that the maximum sum cannot exceed
     * @param currentSum Accumulated sum of current values
     * @param index      Current index for comparing sum values
     * @return The maximum possible sum of integers in the list
     */
    private static int maxSumHelper(List<Integer> L, int n, int currentSum, int index) {
        // base case
        if (index >= L.size()) {
            return currentSum;
        }

        // recursive case when the current sum cannot add the new integer
        if (L.get(index) > n - currentSum) {
            return maxSumHelper(L, n, currentSum, index + 1);
        }

        // recursive case when the current sum can add the new integer
        return Math.max(maxSumHelper(L, n, currentSum, index + 1),
                maxSumHelper(L, n, currentSum + L.get(index), index + 1));
    }

    // ----------------------------------Partitionable------------------------------------------------------//

    /**
     * This method returns a boolean that indicates whether the given list of
     * integers can be divided to two lists with equal sums. Calls the
     * partitionableHelper() method with the given param. O(n) space; O(2^n) time.
     * 
     * @param L List of integers
     * @return whether the List L can be separated into two equally summed sublists
     */
    public static boolean partitionable(List<Integer> L) {
        return partitionableHelper(L, 0, 0, 0); // Intialize with L, index 0, and sums both at 0
    }

    /**
     * Helper method for partitionable
     * 
     * @param L     List of integers
     * @param index Compare sums from each side of the array up to this index
     * @param sum1  First sublist sum
     * @param sum2  Second sublist sum
     * @return whether the List L can be separated into two equally summed sublists
     */
    private static boolean partitionableHelper(List<Integer> L, int index, int sum1, int sum2) {
        if (index == L.size()) {
            return sum1 == sum2; // Base Case at the end of the list, check if the sums are equal
        }
        // Continue along the tree adding the next sum to either sum1 or sum2
        return partitionableHelper(L, index + 1, sum1 + L.get(index), sum2)
                || partitionableHelper(L, index + 1, sum1, sum2 + L.get(index));
    }
}
