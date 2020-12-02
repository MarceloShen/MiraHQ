import java.util.*;
import static java.lang.System.out; // I'm lazy
/**
 * Cool beans
 * 
 * @author Marcelo Shen, Ashley Mead, Brandon Yi, Eashver Elango
 */
public class CTCIParenthesesPermutations {

    /**
     * For testing
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        out.println(permutations(3)); // Expected "[((())), (()()), (())(), ()(()), ()()()]"
        out.println(permutations(0)); // Expected "[]"
        out.println(permutations(1)); // Expected "[()]"
    }

    /**
     * Produce all possible valid permutations of parentheses
     * 
     * @param depth number of parenthesis pairs
     * @return an ArrayList with all possible valid permutations with the given depth
     *
     */
    public static String permutations(int depth) {
        // Outliers check
        if (depth <= 0) {
            return "[]";
        }
        // Create StringBuilder and ArrayList
        StringBuilder currentString = new StringBuilder();
        ArrayList<String> result = new ArrayList<String>();

        // Run recursion and return result as String
        recPermutations(result, currentString, depth, 0, 0);
        return result.toString();
    }

    /**
     * The recursive method that generate possible valid outputs.
     * 
     * @param list the list to store the result in
     * @param str string to be edited to store a result
     * @param depth number of parenthesis pairs
     * @param numLeft number of left parentheses at this iteration
     * @param numRight number of right parentheses at this iteration
     */
    private static void recPermutations(ArrayList<String> list, StringBuilder str, int depth, int numLeft, int numRight) {
        // Error Cases
        if (numLeft < numRight || numLeft > depth) {
            return;
        }
        // Final Case for adding finished parentheses
        if (numLeft + numRight == 2 * depth) {
            list.add(str.toString());
            return;
        }

        str.append("("); // add open character
        recPermutations(list, str, depth, numLeft + 1, numRight); // go into recursion with the left parenthesis added
        str.deleteCharAt(str.length() - 1); //Remove character for recursive backtracking

        str.append(")"); // add close character
        recPermutations(list, str, depth, numLeft, numRight + 1); // go into recursion with the right parenthesis added
        str.deleteCharAt(str.length() - 1); // Remove character for recursive backtracking
    }
}