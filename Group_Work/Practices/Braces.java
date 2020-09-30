import java.util.HashMap;
import java.util.Map;

public class Braces {

    public static void main(String[] args) {
        String[] test1 = { "{}[]()" };
        String[] result1 = braces(test1);
        System.out.println(result1[0]);
    }

    private static Map<Character, Character> matches;

    // Complete the braces function below.
    static String[] braces(String[] values) {
        matches = new HashMap<Character, Character>();
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

    private static boolean checkMatching(String current) {
        StringBuilder lefts = new StringBuilder();
        for (int i = 0; i < current.length(); i++) {
            char brace = current.charAt(i);
            if (matches.containsKey(brace)) {
                lefts.append(brace);
            } else {
                if (lefts.length() == 0) {
                    return false;
                }
                if (!(matches.get(lefts.charAt(lefts.length() - 1)) == brace)) {
                    return false;
                } else {
                    lefts.deleteCharAt(lefts.length() - 1);
                }
            }
        }
        return lefts.length() == 0;
    }
}
