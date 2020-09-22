import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * UsingStacksSuitorsLab
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

	public static void recPrintReverse(String target) {
		// TODO
		if (target.length() <= 1) {
			System.out.print(target);
		} else {
			System.out.print(target.charAt(target.length() - 1));
			recPrintReverse(target.substring(0, target.length() - 1));
		}
	}

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

	public static int findPlaceToStand(int numSuitors) {
		// queue implementation
		/*
		Queue<Integer> line = new LinkedList<Integer>();
		for (int i = 1; i <= numSuitors; i++) {
			line.offer(i);
		}
		int count = 0;
		while (line.size() > 1) {
			count++;
			if (count % 3 == 0) {
				line.poll();
			} else {
				line.offer(line.poll());
			}
		}
		// TODO
		return line.poll();
		*/
		
		//stack implementation
		Stack<Integer> line = new Stack<Integer>();
		Stack<Integer> line2 = new Stack<Integer>();
		for (int i = numSuitors; i > 0; i--) {
			line.push(i);
		}
		int count = 0;
		while (line.size()+line2.size() > 1) {
			while (line.size() > 0) {
				count++;
				if (count % 3 == 0) {
					System.out.println(line.pop());
				} else {
					line2.push(line.pop());
				}
			}
			while (line2.size() > 0) {
				count++;
				if (count % 3 == 0) {
					System.out.println(line2.pop());
				} else {
					line.push(line2.pop());
				}
			}
		}
		if (line.size() > 0) {
			return line.peek();
		} else {
			return line2.peek();
		}
	}
	
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
		for (int i = 0; i < 1; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// do nothing here
			}
		}
	}
}
