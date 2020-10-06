import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*-----------------------------------------------------------------------------------
 * 
 *	sum( n ) is a summation algorithm defined as follows:
 *				
 *	(1)		sum( n ) =  n + (n-1) + (n-2) + ... + 1
 * 	(1a) 	sum( 1 ) = 1
 *
 * and from this definition, we can rewrite this formula in terms of itself, such that:
 *			
 *	(2)	    sum( n ) = n + sum( n - 1 ) 
 *
 * and we can do this again
 *
 *	(3)    	sum( n ) = n + ( n - 1) + sum( n - 2 ) 
 *
 * and so on, and so forth, we finally end up with the same as above
 *
 *	(1)	    sum( n ) = n + (n-1) + (n-2) + ... + 1 
 *
 *----------------------------------------------------------------------------------- */

public class ST_7_RecursionLab_Caogang_Shen {

	private static int count = 0;
	private static JTextArea myArea = new JTextArea();

	public static void main(String args[]) { // invoke the recursive method here...

		/**
		 * TODO: switch between the two commented lines below and execute this code,
		 * observing the output for both the iterative solution and the recursive
		 * solution. To watch the recursive behaviour in action, set a breakpoint on the
		 * if statement inside the recursiveSum() function
		 * 
		 */
		// int solution = iterativeSum(20);
		// int solution = recursiveSum(20);
		myArea.setText(myArea.getText() + recursiveFactorial(10) + "\n" + recursiveExponential(2, 10) + "\n"
				+ recursiveFibonacci(10) + "\n" + recursiveCombination(10, 5));
		System.out.println(myArea.getText());
		// good form to include an exit call when GUIing in Java
		System.exit(0);
	}

	/**
	 * recursion is similar to iterative looping, but we use method calls to repeat
	 * computations (or decompose the problem) instead of explicit looping control
	 * structures
	 */
	public static int recursiveSum(int n) {
		updateRecursiveDisplay(n); // overhead for nice output, not required
		if (n == 1) // if we're at the base case...
			return 1; // then return the answer to the simplest problem which we know how to solve
		else // otherwise, we rely on the fact that sum( n ) = n + sum( n - 1 ) and keep
				// recursing
			return (n + recursiveSum(n - 1));
		// for this method to terminate, we must be breaking the problem down into
		// smaller
		// and smaller problems, until we reach the simplest form of the problem which
		// we know
		// how to solve (in this case, it's the fact that sum( 1 ) == 1 )

		// the iterative counterpart to the above recursion
		// notice how it's longer? At times, an iterative solution may require more code
		// than the recursive counterpart,
		// but, the recursive solution is slower and more memory intensive. We can
		// always recast recursion as iteration.
	}

	public static int iterativeSum(int i) {
		int total = 0;

		for (int n = i; n >= 1; n--) {
			updateIterativeDisplay(n);
			total = total + n;
		}
		return total;
	}

	public static void updateIterativeDisplay(int n) {
		count++;
		String text = myArea.getText();

		text += "\n/*******************Loop iteration " + count + "**************************************";
		text += "\n Calling iterativeSum( int n = " + n + " ). Total += " + n;
		text += "\n***************************************************************************/";

		myArea.setText(text);
	}

	// ignore this method unless interested in the output string
	public static void updateRecursiveDisplay(int n) {

		count++;
		String text = myArea.getText();

		if (count == 1) {
			text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}

		text += "\n/*******************Method invocation " + count + "*********************";

		text += "\n Calling recursiveSum( int n = " + n + " ). ";
		text += "\n The return statement from this function will resolve in " + (n - 1)
				+ " more recursive method calls...";

		if (n != 1) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( "
					+ (n - 1) + " ));";
		} else {
			text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";

		myArea.setText(text);

	}

	// My code starts here
	/**
	 * Using recursives to solve factorial
	 * 
	 * @param n the number of times to loop
	 * @return n!, or n * (n - 1) * ... * 1
	 */
	public static int recursiveFactorial(int n) {
		if (n <= 1) {
			return n;
		} else {
			return (n * recursiveFactorial(n - 1));
		}
	}

	public static int recursiveFactorial(int n, int m) {
		if (n <= m) {
			return 1;
		} else {
			return (n * recursiveFactorial(n - 1, m));
		}
	}

	/**
	 * Using recursives to solve exponential
	 * 
	 * @param x the base number of the exponential
	 * @param n the exponent
	 * @return x^n, or x multiply itself n times
	 */
	public static int recursiveExponential(int x, int n) {
		if (n == 0) {
			return 1;
		} else {
			// return x * (recursiveExponential(x, n - 1));
			if (n % 2 == 0) {
				return ((int) Math.pow((recursiveExponential(x, n / 2)), 2));
			} else {
				return (x * (int) Math.pow((recursiveExponential(x, (n - 1) / 2)), 2));
			}
		}
	}

	// recursiveFactorial takes O(n) time & space
	// recursiveExponential takes O(log n) time & space
	/**
	 * Use recursion to find the fibonacci number at index n
	 * 
	 * @param n the index of the fibonacci number
	 * @return the fabonacci number
	 */
	public static int recursiveFibonacci(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return (recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2));
		}
	}

	/**
	 * Find the combination, or find the number to choose r objects from n objects
	 * 
	 * @param n the total number of objects
	 * @param r the number of objects needed
	 * @return the total number of combinations
	 */
	public static int recursiveCombination(int n, int r) {
		if (r > n) {
			return 0;
		} else {
			return recursiveFactorial(n, r) / recursiveFactorial(n - r);
		}
	}
}
