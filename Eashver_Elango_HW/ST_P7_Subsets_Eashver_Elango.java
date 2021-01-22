import java.util.*;

/**
 * Subset method
 * 
 * @author Eashver Elango
 */

public class ST_P7_Subsets_Eashver_Elango {

    /**
     * Test Cases for subSets method
     * 
     * 
     */
    public static void main(String[] args) {
        List<String> result0 = subSets("");
        System.out.println(result0.toString());
        System.out.print("\n");

        List<String> result9 = subSets(null);
        System.out.println(result9);
        System.out.print("\n");

        List<String> result1 = subSets("abc");
        for (String subset : result1) {
            System.out.print(subset + ", ");
        }

        System.out.print("\n");

        List<String> result2 = subSets("abfcdegls");
        for (String subset : result2) {
            System.out.print(subset + ", ");
        }

        System.out.print("\n");

        List<String> result3 = subSets("abfcdegls");
        for (String subset : result3) {
            System.out.print(subset + ", ");
        }

        System.out.print("\n");

        List<String> result4 = subSets("skdlwoladifja");
        for (String subset : result4) {
            System.out.print(subset + ", ");
        }

        System.out.print("\n");
    }

    /**
     * This method generates all possible subSets from characters in given string
     * O(2^n) time because each node splits into two more nodes everytime
     * 
     * @param set The given string that we get subsets from
     * @return All the possible subsets from the characters from the original string
     */
    public static List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        // edge cases
        if (set == null || result.size()==1) {
            return result;
        }
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(array, 0, sb, result);
        return result;
    }

    /**
     * DFS (Depth First Search); Go as deep as you can in each branch of the tree
     * O(2^n). Look at previous method for explanation
     * 
     * @param arr   Character array representing the string
     * @param index Starting index of the branch
     * @param sb    StringBuilder to build each combination
     * @param result   List of all currently created subsets
     */
    private static void dfs(char[] array, int index, StringBuilder sb, List<String> result) {
        // Base Case when we reach end of array
        if (index == array.length) {
            // collect result
            result.add(sb.toString());
            return;
        }

        // Recursive Rule

        // Case1: add arr[index] to the solution prefix
        sb.append(array[index]);
        dfs(array, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        // Case2: do not add arr[index] to the solution prefix
        dfs(array, index + 1, sb, result);
    }
}

