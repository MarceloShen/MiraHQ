package WordCount;

import java.io.*;
import java.util.*;

public class WordCount {
	// minimum number of occurrences needed to be printed - 2000;
	public static final int OCCURRENCES = 2000;

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("This program displays the most frequently occurring " + "words from the book Moby-Dick");
		System.out.println();

		// read the book into a map
		Scanner in = new Scanner(new File("Group_Work\\Assignments\\WordCount\\mobydick.txt"));
		// Scanner in = new Scanner(new File(System.getProperty("user.dir") + "\\mobydick.txt"));
		Map<String, Integer> wordCountMap = getCountMap(in);

		for (String word : wordCountMap.keySet()) {
			int count = wordCountMap.get(word);
			if (count > OCCURRENCES) {
				System.out.println(word + " occurs " + count + " times.");
			}
		}

		for (String word : wordCountMap.keySet()) {
			if (word.charAt(0) == 'a') {
				int count = wordCountMap.get(word);
				System.out.println(word + " occurs " + count + " times.");
			}
		}
		
	}

	// Reads book text and returns a map from words to counts.
	public static Map<String, Integer> getCountMap(Scanner in) {
		Map<String, Integer> wordCountMap = new TreeMap<>();

		while (in.hasNext()) {
			// String word = in.next().toLowerCase();
			String word = in.next().toLowerCase().replaceAll("\\p{Punct}", ""); //remove punctuation
			
			if (word.isEmpty()) {
				continue;
			}

			if (wordCountMap.containsKey(word)) {
				// seen this word before; increment count
				int count = wordCountMap.get(word);
				wordCountMap.put(word, count + 1);
			} else {
				// never seen this word before
				wordCountMap.put(word, 1);
			}
		}
		return wordCountMap;
	}
}
