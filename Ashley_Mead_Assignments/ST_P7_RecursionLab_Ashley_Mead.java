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


	
public class ST_P7_RecursionLab_Ashley_Mead {
	private static JTextArea myArea = new JTextArea();
	private static int count = 0;
	
	public static void main( String args[] ) {	//invoke the recursive method here...
		
		/**
		 * TODO: switch between the two commented lines below and execute this code, 
		 * observing the output for both the iterative solution and the recursive solution.
		 * To watch the recursive behaviour in action, set a breakpoint on the if statement
		 * inside the recursiveSum() function
		 * 
		 */
		// int solution = iterativeSum( 20 );
		int solution = recursiveSum( 20 );
		
		
		
		System.out.println(myArea.getText() + "\nfactorial(5): " + factorial(5) + "\nexponent(2, 3): " 
			+ exponent(2, 3) + "\nexponentHalf(3, 3): " + exponentHalf(3, 3) + "\ncombinations(5, 3): " + combinations(5, 3));
		System.out.println("Fibonacci sequence:");
		for(int i = 1; i < 9; i++) {
            System.out.println(fib(i));
        }
			//good form to include an exit call when GUIing in Java
		System.exit(0);
	}
	
	
	
	/** recursion is similar to iterative looping, but we
	 *  use method calls to repeat computations (or decompose the problem) 
	 *  instead of explicit looping control structures 
	 */
	public static int recursiveSum( int n ) {
		updateRecursiveDisplay(n);			//overhead for nice output, not required
		if( n == 1)			//if we're at the base case...
			return 1;		//then return the answer to the simplest problem which we know how to solve
		else				//otherwise, we rely on the fact that sum( n ) = n + sum( n - 1 ) and keep recursing
			return ( n + recursiveSum( n - 1) );
	}						//for this method to terminate, we must be breaking the problem down into smaller
							//and smaller problems, until we reach the simplest form of the problem which we know
							//how to solve (in this case, it's the fact that sum( 1 ) == 1 )

	//the iterative counterpart to the above recursion
	//notice how it's longer? At times, an iterative solution may require more code than the recursive counterpart, 
	//but, the recursive solution is slower and more memory intensive.  We can always recast recursion as iteration.
	public static int iterativeSum( int i ) {
		int total = 0;
		
		for( int n = i; n >= 1; n--) {
			updateIterativeDisplay(n);
			total = total + n;
		}
		return total;
	}						
	
	public static void updateIterativeDisplay(int n) {
		count++;
		String text = myArea.getText();
		
		text += "\n/*******************Loop iteration " + count + "**************************************";
		text += "\n Calling iterativeSum( int n = " + n +" ). Total += " + n;
		text += "\n***************************************************************************/";
		
		myArea.setText( text );
	}
							
							
	//ignore this method unless interested in the output string						
	public static void updateRecursiveDisplay(int n) {
		
		count++;
		String text = myArea.getText();
		
		
		if( count == 1 )  {
			text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}
		
		
		text += "\n/*******************Method invocation " + count + "*********************";
		
		
		text += "\n Calling recursiveSum( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";
		
		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( "+ (n - 1) +" ));";
		} else {
			text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";
		
		myArea.setText( text );
		
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------//

	/**
     * Factorial calculation
     * @param n Number whose factorial is to be calculated 
     * @return Calculated value of n!
     */
    public static int factorial(int n) {
        
        if(n == 1) {
            // System.out.print(n);
            return 1;
        }
        // System.out.print(num + " * ");
        return n * factorial(n - 1);
    }

    /**
     * Exponent calculation
     * O(n)
     * @param x base
     * @param n exponent
     * @return calculated answer
     */
    public static int exponent(int x, int n) {
        // base case
        if(n == 0) {
            return 1;
        }
        return x * exponent(x, n-1);
    }

    /**
     * Exponent calculation but by cutting the problem in half at each step
     * O(n^2)
     * @param x base
     * @param n exponent
     * @return calculated answer
     */
    public static int exponentHalf(int x, int n) {
        // base case
        if(n == 0) {
            return 1;
        }

        if(n % 2 == 0) {
            // x^n= ( x^(n/2))^2
            return exponent(exponentHalf(x, n/2), 2);
        }
        else {
            //x^n= x *( x^(( n-1 )/2))2
            return x * exponent(exponentHalf(x, (n-1)/2), 2);
        }
	}
	
    /**
     * Fibonacci number
     * @param n "index" of desired fibonnacci number in the fibbonacci sequence
     * @return fibonnacci number at n
     */
    public static int fib(int n) {
        // base case
        if(n == 0 || n == 1) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

    /**
     * Number of combinations in a set
     * @param n number of items in the set
     * @param r number of elements to be picked from the set
     * @return number of ways we can pick r elements from n
     */
    public static int combinations(int n, int r) {
        // edge case
        if(r > n) {
            return 0;
        }

        return factorial(n)/(factorial(r)*factorial(n-r));
    }
}