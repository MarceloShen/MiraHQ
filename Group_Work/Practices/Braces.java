import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This class serves to check whether braces in an array of strings are balanced
 * 
 * @author Marcelo Shen, Ashley Mead, Brandon Yi, Eashver Elango
 */
public class Braces {

    /**
     * Test example cases
     * 
     * @param args do nothing
     */
    public static void main(String[] args) {
        String[] test1 = { "{}[]()", "()())()()()()()))(()(", "{[()]}", "{]}()" };
        String[] result1 = braces(test1);
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i]);
        }

    }

    private static Map<Character, Character> matches;

    /**
     * Checks whether each string in an array of strings has balanced left and right
     * braces by disassembling the array to check each string in checkMatching()
     * method
     * 
     * @param values An array of strings where each string contains a series of left
     *               and right braces
     * @return An array of strings that indicates whether in each case the braces in
     *         the string are balanced
     * 
     */
    public static String[] braces(String[] values) {
        matches = new HashMap<>();
        matches.put('(', ')');
        matches.put('[', ']');
        matches.put('{', '}');
        String[] result = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String currentBraces = values[i];
            result[i] = checkMatching(currentBraces) ? "YES" : "NO";
        }
        return result;
    }

    /**
     * Checks whether a string has balanced left and right braces. Iterate through
     * the string; whenever it reaches a left braces, the program adds the braces to
     * a stack; otherwise it checks whether the last left braces in the stack
     * matches the right braces. If there is nothing left in the stack after
     * iterating through the string, return true; otherwise return false.
     *
     * 
     * @param current String containing a series of left and right braces
     * @return Whether the braces in the string are balanced
     */
    private static boolean checkMatching(String current) {
        Stack<Character> lefts = new Stack<>();
        for (int i = 0; i < current.length(); i++) {
            char brace = current.charAt(i);
            if (matches.containsKey(brace)) {
                lefts.push(brace);
            } else {
                if (lefts.isEmpty() || matches.get(lefts.pop()) != brace) {
                    return false;
                }
            }
        }
        return lefts.isEmpty();
    }
}
