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


	
public class ST_P7_RecursionLab_Eashver_Elango {
	private static JTextArea myArea = new JTextArea();
	private static int count = 0;
	
	public static void main( String args[] ) {	//invoke the recursive method here...
		
		/**
		 * switch between the two commented lines below and execute this code, 
		 * observing the output for both the iterative solution and the recursive solution.
		 * To watch the recursive behaviour in action, set a breakpoint on the if statement
		 * inside the recursiveSum() function
		 * 
		 */
	    //int solutionSum1 = iterativeSum( 20 );
        //int solutionSum1 = recursiveSum( 20 );
        myArea.setText(myArea.getText() + recursiveFactorial(5) + "\n" + recursiveExponent1(2, 4) + "\n" +
                recursiveExponent2(3, 3) + "\n" + recursiveFib(6) + "\n" + recursiveCombination(19, 6));
		System.out.println(myArea.getText());
		
		
		
		
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
    
    public static int recursiveFactorial(int i){
        if(i <= 1){
            return 1;
        } else {
            int result = i * recursiveFactorial(i-1);
            return result;
        }
    }

    public static int recursiveExponent1(int i, int x){
        if(i == 0){
            return 1;
        } else {
            return x * recursiveExponent1(i-1, x);
        }
    }

    public static int recursiveExponent2(int i, int x){
        if(i==0){
            return 1;
        } else if(i % 2 == 0) {
            return (int) Math.pow(recursiveExponent2(i/2, x), 2);
        } else {
            return x * (int) Math.pow(recursiveExponent2((i-1)/2, x), 2);
        }
    }

    public static int recursiveFib(int i){
        if(i <= 1){
            return i;
        } else {
            int result = recursiveFib(i-1) + recursiveFib(i-2);
            return result;
        }
    }

    public static int recursiveCombination(int r, int n){
        return recursiveFactorial(n) / (recursiveFactorial(r) * recursiveFactorial(n-r));
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
}
