package WordCount;
import java.io.*;
import java.util.*;
/**
 * -- output in WordCount1.out --
 *
 * Reflection: we learned how to use maps and keys
 * The program was originally counting words with punctuation as separate
 * words, so we edited the program to make it remove punctuation in words as a team
 *
 * Contributions: We all wrote parts of the program. No person worked on specific part.
 * We also discussed together about how to solve it.
 * 
 * @author Marcelo Shen, Ashley Mead, Brandon Yi, Eashver Elango
 */
public class WordCount1{
	// minimum number of occurrences needed to be printed - 2000;
	public static final int OCCURRENCES = 2000;

	/**
	 * Test cases
	 * 
	 * @param args meaningless artifact
	 * @throws FileNotFoundException if the file is not found, as described clearly in its name
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// read the book into a map
		Scanner s = new Scanner(new File("Group_Work\\Assignments\\WordCount\\mobydick.txt"));	
		Map<String, Integer> occurrenceMap = getCountMap(s);
		
		// Iterate through Map, print all words with counts above OCCURENCES variable
		for(Map.Entry<String, Integer> entry : occurrenceMap.entrySet()){
			if (entry.getValue() >= OCCURRENCES) {
				System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times.");
			}
		}
	}

	/** 
	 * Reads book text and returns a map with words and their numbers of occurence.
	 * 
	 * @param in scanner's input stream
	 * @return a map of pairs of words and their individual frequency
	 */
	public static Map<String, Integer> getCountMap(Scanner in) {
		// Create a Tree Map that holds word counts
		Map<String, Integer> wordCountMap = new TreeMap<>();
	
		while(in.hasNext()) {
			// Get the next word utilizing Scanner. Convert to lower case and remove punctuation
			String nextWord = in.next().toLowerCase().replaceAll("\\p{Punct}", "");
		
			if (nextWord.isEmpty()) { // Edge case if nextword is accidently punctuation
				continue;
			}
			// If the word has already been found, add one in map
			if(wordCountMap.containsKey(nextWord)) {
				// Increment the number of occurences (the value)
				wordCountMap.put(nextWord, wordCountMap.get(nextWord) + 1);
			}
			// If the word has not already been found, add it to the map
			else {
				wordCountMap.put(nextWord, 1);
			}
		}
		
		return wordCountMap;
	}
}
