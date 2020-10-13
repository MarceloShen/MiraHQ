import java.util.ArrayList;
import java.util.List;

/**
 * Subset method
 * 
 * @author Marcelo Shen
 */

public class ST_7_AllSubsets_Caogang_Shen {

    /**
     * Test Cases for subSets method
     * 
     * @param args nothing here to worry about...
     */
    public static void main(String[] args) {
        List<String> result1 = subSets("abc");
        for (String subset : result1) {
            System.out.print(subset + ", ");
        }

        System.out.println();

        List<String> result2 = subSets("abcdef");
        for (String subset : result2) {
            System.out.print(subset + ", ");
        }

        System.out.println();
    }

    /**
     * This method check for all possible subSets of characters from characters in
     * the original string. O(2^n) time complexity, O(n) space complexity
     * 
     * @param set The sample string that we get subsets from
     * @return All the possible subsets that has the characters from the original
     *         string
     */
    public static List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        // edge cases
        if (set == null) {
            return res;
        }
        char[] arr = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(arr, 0, sb, res);
        return res;
    }

    /**
     * DFS (Depth First Search); go one step deeper for both branches each recursion
     * O(2^n)
     * 
     * @param arr   Character array representing the string
     * @param index Starting index of the branch
     * @param sb    StringBuilder to build each combination
     * @param res   List of all currently created subsets
     */
    private static void dfs(char[] arr, int index, StringBuilder sb, List<String> res) {
        // Base Case when we reach end of array
        if (index == arr.length) {
            // collect result
            res.add(sb.toString());
            return;
        }

        // Recursive Rule

        // Case1: add arr[index] to the solution prefix
        sb.append(arr[index]);
        dfs(arr, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        // Case2: do not add arr[index] to the solution prefix
        dfs(arr, index + 1, sb, res);
    }
}
