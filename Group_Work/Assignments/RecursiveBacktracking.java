import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Recursive Backtracking Example Methods
 * 
 * @author Marcelo Shen, Ashley Mead, Eashver Elango, Brandon Yi
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
     * origin. Calls the travelHelper() method with given params. 
     *  O(x + y) space;  O(3^(x+y)) time.
     * 
     *                   _____________(0, 0)_______________
     *                 /                 |                 \
     *              _(1, 0)_          _(0, 1)_         ___(1, 1)__
     *             /   |    \        /    |   \       /     |     \
     *           (2, 0)(1, 1)(2, 1)(1, 1)(0, 2)(1, 1)(2, 1)(1, 2)(2, 2)
     *                                  ...
     * 
     * 
     * @param x horizontal distance to move
     * @param y vertical distance to move
     */
    public static void travel(int x, int y) {
        StringBuilder currentString = new StringBuilder();
        travelHelper(x, y, currentString);
    }

    /**
     * Base Case is where x <= 0 || y <= 0. Recursive Case is anything else. Level
     * ranges from max(x, y) to (x + y). Number of Branches is 0, 1, or 3. If both x
     * and y <= 0, there is 0 branch. Else if either x or y (but not both) > 0,
     * there is 1 branch. Else there are 3 branches
     * 
     * 
     * @param x             horizontal distance to move
     * @param y             vertical distance to move
     * @param currentString the current route, using N - North, E - East, NE -
     *                      Northeast
     * 
     */
    private static void travelHelper(int x, int y, StringBuilder currentString) {
        // base case
        if (x <= 0 && y <= 0) {
            System.out.println(currentString.toString());
            return;
        }

        // Horizontal calculations based on x (taking a step east)
        if (x > 0) {
            currentString.append("E ");
            // Case where you move 1 unit less far horizontally
            travelHelper(x - 1, y, currentString);
            // Remove the redundant character from the previous level
            currentString.delete(currentString.length() - 2, currentString.length());
        }

        // Vertical calculations based on y (taking a step north)
        if (y > 0) {
            currentString.append("N ");
            // Case where you move 1 unit less far vertically
            travelHelper(x, y - 1, currentString);
            // Remove the redundant character from the previous level
            currentString.delete(currentString.length() - 2, currentString.length());
        }

        // Diagonal calculations based on x and y (taking a step northeast)
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
     * 
     * 
     *                              _______""________
     *                             /                 \
     *                            0                   1
     *                        /       \           /       \
     *                       00       01         10       11
     *                      /  \     /  \       /  \     /  \
     *                     000 001  010 001   100  101  110 111
     *                                     ...
     */
    public static void countBinary(int n) {
        StringBuilder currentString = new StringBuilder();
        countBinaryHelper(n, currentString);
    }

    /**
     * Base Case: n <= 0; Recursive Case: Everything else. Levels: n. Branches: 2,
     * one for adding 0, one for adding 1 (0 branch if reaches the base case).
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
     * method with the given params. O(n) space, O(2^n) * n time.
     * 
     * Example tree:
     * L = [10, 20, 30], n = 20
     * 
     *                      0
     *             ________/ \__________
     * 10        10                    0
     *       ___/ \___             ___/ \___
     * 20   X         10         20        0
     *               / \        / \       / \
     * 30           X  10      X  20     X   0
     *                    ...
     * 
     * 
     * @param L List of integers
     * @param n Limit that the maximum sum cannot exceed
     * @return The maximum possible sum of integers in the list
     */
    public static int maxSum(List<Integer> L, int n) {
        return maxSumHelper(L, n, 0, 0);
    }

    /**
     * Base Case: index >= L.size(); Recursive Case: Everything else. Levels:
     * L.size() - index Branches: 0 if base case, 1 if (current sum + integer) >
     * limit n, 2 other wise
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

        // recursive case when the current sum can add the new integer.
        return Math.max(maxSumHelper(L, n, currentSum, index + 1), // don't add the current number to sum
                maxSumHelper(L, n, currentSum + L.get(index), index + 1)); // add the current number to the sum
    }

    // ----------------------------------Partitionable------------------------------------------------------//

    /**
     * This method returns a boolean that indicates whether the given list of
     * integers can be divided to two lists with equal sums. Calls the
     * partitionableHelper() method with the given param. O(n) space; O(2^n) time.
     * 
     * @param list List of integers
     * @return whether the List L can be separated into two equally summed sublists
     */
    public static boolean partitionable(List<Integer> list) {
        return partitionableHelper(list, 0, 0, 0); // Intialize with L, index 0, and sums both at 0
    }

    /**
     * Base Case: index >= list.size(); Recursive Case: Everything other index.
     * Levels: list.size() - index. Branches: 0 if base case, 2 otherwise
     * 
     * @param list  List of integers
     * @param index Compare sums from each side of the array up to this index
     * @param sum1  First sublist sum
     * @param sum2  Second sublist sum
     * @return whether the List L can be separated into two equally summed sublists
     * 
     * Example partitionable([1, 2, 3, 4, 5, 6], 0, 0, 0)
     *                              ______(0,0)_______
     *                             /                  \
     *                       (1,0)                    (0,1)
     *                     /       \               /        \
     *                  (3,0)      (1,2)        (2,1)      (0,3)
     *                 /     \    /     \       /   \      /   \
     *              (6,0) (3,3) (4,2) (1,5) (5,1) (2,4) (3,3) (0,6)
     * ...
     */
    private static boolean partitionableHelper(List<Integer> list, int index, int sum1, int sum2) {
        if (index == list.size()) {
            return sum1 == sum2; // Base Case at the end of the list, check if the sums are equal
        }
        // Continue along the tree adding the next sum to either sum1 or sum2
        return partitionableHelper(list, index + 1, sum1 + list.get(index), sum2) // add current num to sum1
                || partitionableHelper(list, index + 1, sum1, sum2 + list.get(index)); // add current num to sum2
    }
}
