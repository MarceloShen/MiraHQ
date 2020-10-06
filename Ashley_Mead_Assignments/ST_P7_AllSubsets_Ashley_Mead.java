import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashley Mead
 */
public class ST_P7_AllSubsets_Ashley_Mead {
    /**
     * Test cases
     * @param args not much here
     */
    public static void main(String[] args) {
        List<String> result1 = subSets("abc");
        System.out.println("abc: ");
        for (String subset : result1) {
            System.out.print(subset + ", ");
        }

        System.out.println("\n");
        System.out.println("abcdef: ");
        List<String> result2 = subSets("abcdef");
        for (String subset : result2) {
            System.out.print(subset + ", ");
        }

        System.out.println();
    }

    /**
     * Gets all possible subsets of characters in a string
     * O(2^n)
     * @param set Set of characters (string) to get subsets from
     * @return a list of the resulting subsets
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
     * Gets each possible subset of characters from a character array
     * DFS (Depth First Search)
     * O(2^n)
     * @param arr character array representing the string as separated characters
     * @param index starting index
     * @param sb StringBuilder to accumulate a string
     * @param res resulting subset
     */
    private static void dfs(char[] arr, int index, StringBuilder sb, List<String> res) { 
    
        if (index == arr.length) { 
            //collect result 
            res.add(sb.toString()); 
            return;
        } 
        
        //Case1: add arr[index] to the solution prefix 
        sb.append(arr[index]);
        dfs(arr, index + 1, sb, res); 
        sb.deleteCharAt(sb.length() - 1); 
        
        //Case2: do not add arr[index] to the solution prefix
        dfs(arr, index + 1, sb, res); 
    
    } 
}