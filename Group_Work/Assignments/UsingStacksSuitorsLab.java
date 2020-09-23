import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * UsingStacksSuitorsLab:
 * 
 * This class is mostly a driver for playing with Strings as palindromes, both
 * iteratively and recursively. The UsingStacksSuitorsLab class itself is a
 * runnable object, so it can be passed to a thread in our Queue demo.
 * 
 * @author Caogang Shen, Ashley Mead, Brandon Yi, Eashver Elango
 * 
 */

public class UsingStacksSuitorsLab implements Runnable {
	private static int threadCount = 0;
	private String name;

	public UsingStacksSuitorsLab() {
		name = "#" + threadCount++ + "Thread";
	}

	public static void main(String[] args) {
		String s1 = "food"; // not a palindrome
		String s2 = "racecar"; // a palindrome

		System.out.println("String1 is \"" + s1 + "\"");
		System.out.println("String2 is \"" + s2 + "\"");

		System.out.println(s1 + " reversed is: ");
		printReverse(s1);
		System.out.println(s2 + " reversed is: ");
		printReverse(s2);

		recPrintReverse(s1);
		System.out.println();
		recPrintReverse(s2);
		System.out.println();

		System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
		System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));

		System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
		System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));

		System.out.println("Did we build a Queue of Threads and start them? " + buildThreadQueue());

		int n = 6;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));

		n = 10;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));

	}

	/**
	 * Print a reverse version of the target string
	 * 
	 * @example inputting "abc" will print out "cba"
	 * @param target the target string
	 */
	public static void printReverse(String target) {
		Stack<Character> reverser = new Stack<Character>();
		for (int i = 0; i < target.length(); i++) {
			reverser.push(target.charAt(i));
		}
		for (int i = 0; i < target.length(); i++) {
			System.out.print(reverser.pop());
		}
		System.out.println();
		// TODO: use a stack

	}

	/**
	 * Print a reverse version of the target string, but here is the catch. Ready?
	 * The method is a recursion! Wow amazing! How is it possible?!
	 * 
	 * @example inputting "abc" will print out "cba"
	 * @param target the target string
	 */
	public static void recPrintReverse(String target) {
		// TODO
		if (target.length() <= 1) {
			System.out.print(target);
		} else {
			System.out.print(target.charAt(target.length() - 1));
			recPrintReverse(target.substring(0, target.length() - 1));
		}
	}

	/**
	 * Check whether a string is a palindrome and store it to a boolean
	 * 
	 * @param input a target string
	 * @return whether it is a palindrome string
	 */
	public static boolean isPalindrome(String input) {
		Stack<Character> reverser = new Stack<Character>();
		String reversed = "";

		for (int i = 0; i < input.length(); i++) {
			reverser.push(input.charAt(i));
		}
		for (int i = 0; i < input.length(); i++) {
			reversed += reverser.pop();
		}
		return (input.equals(reversed)); // TODO: use a stack
	}

	/**
	 * Can I just say that the function of this method is SOOO obvious? Also there
	 * is some smart recursion that is implemented in this method
	 * 
	 * @param sentence the target string, except it is called "sentence" for no
	 *                 apparent reason
	 * @return whether it is a palindrome string
	 */
	public static boolean isPalindromeRec(String sentence) {

		if (sentence.length() <= 1) {
			return true;
		} else {
			if (sentence.charAt(0) == sentence.charAt(sentence.length() - 1)) {
				return isPalindromeRec(sentence.substring(1, sentence.length() - 1));
			}
		}
		return false;

		// TODO
	}

	/**
	 * I am a suitor, I got eliminated. That, my friend, is the game.
	 * 
	 * @actual_description given a number of ppl, every third person will be
	 *                     eliminated, return the last one standing
	 * @param numSuitors number of suitors to play this battle royale rip off
	 * @return Winner winner, chicken dinner
	 */
	public static int findPlaceToStand(int numSuitors) {
		if (numSuitors < 1) {
			return -1;
		}
		// queue implementation
		// Queue<Integer> line = new LinkedList<Integer>();
		// for (int i = 1; i <= numSuitors; i++) {
		// line.offer(i);
		// }
		// int count = 0;
		// while (line.size() > 1) {
		// count++;
		// if (count % 3 == 0) {
		// line.poll();
		// } else {
		// line.offer(line.poll());
		// }
		// }
		// return line.poll();
		// // stack implementation
		// Stack<Integer> line = new Stack<Integer>();
		// Stack<Integer> line2 = new Stack<Integer>();
		// for (int i = numSuitors; i > 0; i--) {
		// line.push(i);
		// }
		// int count = 0;
		// while (line.size() + line2.size() > 1) {
		// while (!line.isEmpty()) {
		// count++;
		// if (count % 3 == 0) {
		// System.out.println(line.pop());
		// } else {
		// line2.push(line.pop());
		// }
		// }
		// while (!line2.isEmpty()) {
		// count++;
		// if (count % 3 == 0) {
		// System.out.println(line2.pop());
		// } else {
		// line.push(line2.pop());
		// }
		// }
		// }
		// if (!line.isEmpty()) {
		// return line.peek();
		// } else {
		// return line2.peek();
		// }

		Queue<Integer> lineQueued = new LinkedList<Integer>();
		Queue<Integer> Middiant = new LinkedList<Integer>();
		Stack<Integer> lineStacked = new Stack<Integer>();

		for (int i = 1; i <= numSuitors; i++) {
			Middiant.offer(i);
		}
		int count = 0;
		while (Middiant.size() > 1) {
			if (Math.random() < 0.5) {
				while (!Middiant.isEmpty()) {
					count++;
					if (count % 3 == 0) {
						Middiant.poll();
					} else {
						lineQueued.offer(Middiant.poll());
					}
				}
				while (!lineQueued.isEmpty()) {
					Middiant.offer(lineQueued.poll());
				}
			} else {
				while (!Middiant.isEmpty()) {
					count++;
					if (count % 3 == 0) {
						Middiant.poll();
					} else {
						lineStacked.push(Middiant.poll());
					}
				}
				while (!lineStacked.isEmpty()) {
					Middiant.offer(lineStacked.pop());
				}
			}
		}
		return Middiant.poll();
	}

	/**
	 * This method will create a couple new threads to queue them and run them in
	 * order
	 * 
	 * @warning the console/output/terminal will get spammed by the running threads
	 * @return true if everything works
	 */
	public static boolean buildThreadQueue() { // returns true upon success
		Queue<Thread> q = new LinkedList<Thread>();

		// when our program starts up, it might create multiple threads to use
		q.offer(new Thread(new UsingStacksSuitorsLab()));
		q.offer(new Thread(new UsingStacksSuitorsLab()));
		q.offer(new Thread(new UsingStacksSuitorsLab()));

		System.out.println("Initial Thread order:");
		q.toString();

		// We need to iterate over our pool of threads and call start() on each one
		// Make a loop that dequeues a thread, calls start on it, and enqueues it
		// again
		// TODO:
		for (int i = 0; i < q.size(); i++) {
			Thread current = q.poll();
			current.start();
			// put the thread back
			q.offer(current);
		}

		System.out.println("Thread order after starting:");
		q.toString();

		return true; // on successful start
	}

	/*
	 * No need to edit anything below here, unless you'd like to change the
	 * behaviour of each thread in the thread pool above
	 */

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// do nothing here
			}
		}
	}
}
