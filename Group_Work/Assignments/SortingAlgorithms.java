import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Several examples of sorting algorithms insert sort, bubble sort, merge sort,
 * quick sort and radix sort
 * 
 * ------------------------------------------------------------------
 * We did ***Insert sort, Bubble sort, Merge sort, and Quick sort***
 * ------------------------------------------------------------------
 * 
 * @author Marcelo Shen, Ashley Mead, Eashver Elango, Brandon Yi
 */

public class SortingAlgorithms {

	// The array to sort
	private int[] a;
	// A copy of the original array
	private int[] initialArray;
	// Default dimension of a
	private static final int SIZE = 10;
	// Maximum number of digits of the elements of a(for radix sort)
	private static final int MAXIMUM_NUMBER_OF_DIGITS = 3;

	/**
	 * Generate an array of random integers of size SIZE
	 */
	public SortingAlgorithms() {
		// Use the other constructor
		this(SIZE);
	}

	/**
	 * Generate an array of random integers of size n
	 */
	public SortingAlgorithms(int n) {
		// Take the default size if n <=0
		if (n < 0) {
			n = SIZE;
		}
		// Create a
		a = new int[n];
		// Fill a with random integers (between 0 and 10^MAXIMUM_NUMBER_OF_DIGITS-1)
		double max = Math.pow(10, MAXIMUM_NUMBER_OF_DIGITS);
		for (int i = 0; i < n; i++) {
			a[i] = (int) (Math.random() * max);
		}
		// Initialize initialArray and make a copy of a in initialArray
		initialArray = Arrays.copyOf(a, n);
	}

	/**
	 * write the array as a String (toString is automatically called when using
	 * print with a SortingAlgorithms)
	 */
	public String toString() {
		if (a.length <= 20) {
			return Arrays.toString(a);
		} else {
			return "";
		}
	}

	/**
	 * Sort the array with insert sort
	 */
	public void insertSort() {
		insert(a.length);
	}

	/**
	 * Precondition: a is ordered from 0 to i-1 Postcondition: a is ordered from 0
	 * to i
	 */
	private void insert(int n) {
		for (int i = 1; i < n; i++) {
			// saves the current value
			int key = a[i];
			int j = i - 1;
			// moves any value behind and larger than the current value
			// ahead of the current value 
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			// puts the current value behind the last value moved
			a[j + 1] = key;
		}
	}

	/**
	 * Sort the array with bubble sort
	 */
	public void bubbleSort() {
		boolean isSorted = false;
		while (!isSorted) {
			// if no switching needs to be done, the items are sorted
			isSorted = true;

			for (int i = 0; i < a.length - 1; i++) {
				// if the current item is greater than the next one
				if (a[i] > a[i + 1]) {
					isSorted = false;
					// swap the items (so the lower item is before the higher one)
					swap(i, i + 1);
				}
			}
		}
	}

	/**
	 * Sort the array with merge sort (a faster algorithm)
	 */
	public void mergeSort() {
		divideInTwoSortAndMerge(0, a.length-1);
	}

	/**
	 * Divide the array in two Order each part Merge the two ordered parts
	 */
	private void divideInTwoSortAndMerge(int first, int last) {
		if (first < last) {
			// Midpoint
			int m = (first + last) / 2;
			// Sort a[first,...,mid] (using divideInTwoSortAndMerge)
			divideInTwoSortAndMerge(first, m);
			// Sort a[mid+1,...,last] (using divideInTwoSortAndMerge)
			divideInTwoSortAndMerge(m + 1, last);
			// Merge sorted halves
			merge(first, m, last);
		}
		// else
		// Base case: nothing to do
	}

	/**
	 * Precondition: first<=mid<=last a[first,...,mid] is sorted in increasing order
	 * a[mid+1,...,last] is sorted in increasing order Postcondition
	 * a[first,...,last] is sorted in increasing order
	 */
	private void merge(int first, int mid, int last) {

		// Method: copy the two halves in a temp array in increasing order

		// Create sizes of temp arrays
		int n1 = mid - first + 1;
		int n2 = last - mid;

		// Initialize Temp Arrays
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copy Data into Temp Arrays
		for (int i = 0; i < n1; ++i)
			L[i] = a[first + i];
		for (int j = 0; j < n2; ++j)
			R[j] = a[mid + 1 + j];

		// Merge temp arrays
		int i = 0;
		int j = 0;
		int k = first;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}
			k++;
		}
		// Copy remaining elements in L[]
		while (i < n1) {
			a[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements in R[]
		while (j < n2) {
			a[k] = R[j];
			j++;
			k++;
		}
	}

	/**
	 * Sort using quicksort
	 */
	public void quickSort() {
		pickPivotAndSort(0, a.length - 1);
	}

	/**
	 * Pick the pivot and sort with respect to the pivot
	 */
	private void pickPivotAndSort(int first, int last) {
		if (first < last) {
			// pick the pivot
			int pivot = a[pickPivotLocation(first, last)];

			// Place the pivot at the start of the array

			// Go through the array: place to the left of the pivot, any
			// element less than the pivot
			int toTheLeft = first; // index of the last element
									// to the left of the pivot
			for (int i = first; i <= last; i++) {
				if (a[i] < pivot) {
					toTheLeft++;
					swap(toTheLeft, i);
				}
			}
			swap(toTheLeft, first);
			pickPivotAndSort(first, toTheLeft - 1);
			pickPivotAndSort(toTheLeft + 1, last);
			// Place the pivot between the elements less than the pivot
			// and the elements greater than or equal to the pivot

			// Repeat the process with what is to the left of the pivot
			// and what is to the right of the pivot

		}
		// else
		// Base case: nothing to do
	}

	/**
	 * Find the location of the pivot
	 */
	private int pickPivotLocation(int first, int last) {
		return first; // keep it simple
	}

	/**
	 * Swap the values of a[i] and a[j]
	 */
	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * Sort the array using radix sort precondition: the maximum number of digits of
	 * the integers in the array is MAXIMUM_NUMBER_OF_DIGITS
	 */
	public void radixSort() {
		// Use an array of 10 ArrayLists to groups the elements of the array

		// Order the array by grouping the elements of a according to their
		// digits at position d
		for (int d = 0; d < MAXIMUM_NUMBER_OF_DIGITS; d++) {
			// Initialize the digit groups

			// Group the elements of a according to the value of their digit
			// at position d

			// Copy the result in a

		}
	}

	/**
	 * Test the Sorting algorithm class
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("Enter the size of the array (<=0 to stop): ");
			int n = scan.nextInt();
			if (n <= 0) {
				break;
			}

			// Create a SortingAlgorithms with an array of size n
			SortingAlgorithms sa = new SortingAlgorithms(n);

			// Print the array before sorting
			if (sa.a.length < 20) {
				System.out.println("Before sorting");
				System.out.println(sa);
			}

			// Test insert sort
			// Clock time just before the call
			long t1 = System.currentTimeMillis();
			sa.insertSort();
			// Clock time after the call
			long t2 = System.currentTimeMillis();
			System.out.println("With insert sort:");
			System.out.println("Execution time =" + (t2 - t1) + " ms");
			if (sa.a.length < 20)
				System.out.println(sa);

			// Test bubble sort (on the same array)
			System.arraycopy(sa.initialArray, 0, sa.a, 0, sa.initialArray.length);
			// Clock time just before the call
			t1 = System.currentTimeMillis();
			sa.bubbleSort();
			// Clock time after the call
			t2 = System.currentTimeMillis();
			System.out.println("With bubble sort:");
			System.out.println("Execution time =" + (t2 - t1) + " ms");
			if (sa.a.length < 20)
				System.out.println(sa);

			// Test merge sort (on the same array)
			System.arraycopy(sa.initialArray, 0, sa.a, 0, sa.initialArray.length);
			// Clock time just before the call
			t1 = System.currentTimeMillis();
			sa.mergeSort();
			// Clock time after the call
			t2 = System.currentTimeMillis();
			System.out.println("With merge sort:");
			System.out.println("Execution time =" + (t2 - t1) + " ms");
			if (sa.a.length < 20)
				System.out.println(sa);

			// Test quick sort (on the same array)
			System.arraycopy(sa.initialArray, 0, sa.a, 0, sa.initialArray.length);
			// Clock time just before the call
			t1 = System.currentTimeMillis();
			sa.quickSort();
			// Clock time after the call
			t2 = System.currentTimeMillis();
			System.out.println("With quick sort:");
			System.out.println("Execution time =" + (t2 - t1) + " ms");
			if (sa.a.length < 20)
				System.out.println(sa);

			// Test radix sort (on the same array)
			System.arraycopy(sa.initialArray, 0, sa.a, 0, sa.initialArray.length);
			// Clock time just before the call
			t1 = System.currentTimeMillis();
			sa.radixSort();
			// Clock time after the call
			t2 = System.currentTimeMillis();
			System.out.println("With radix sort:");
			System.out.println("Execution time =" + (t2 - t1) + " ms");
			if (sa.a.length < 20)
				System.out.println(sa);

			// Compare with the Java API
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < sa.initialArray.length; i++)
				l.add(new Integer(sa.initialArray[i]));
			// Clock time just before the call
			t1 = System.currentTimeMillis();
			// Sort with Collections.sort
			Collections.sort(l);
			// Clock time after the call
			t2 = System.currentTimeMillis();
			System.out.println("With a sort from the Collections class:");
			System.out.println("Execution time =" + (t2 - t1) + " ms");
			if (l.size() < 20)
				System.out.println(l);

		}
		scan.close();
	}
}
