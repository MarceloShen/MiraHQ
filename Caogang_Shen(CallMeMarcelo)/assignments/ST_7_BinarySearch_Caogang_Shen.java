/**
 * Template file for Assignment Binary Search Author: Caogang Shen Period: 7th
 * Period
 */
public class ST_7_BinarySearch_Caogang_Shen {

	public static void main(String[] args) {
		// sample tests
		// test for binarySearch()
		int[] inputArray1 = { 1, 2, 3, 4, 5 };
		int result1 = binarySearch(inputArray1, 3);
		System.out.println("result1: " + result1); // expect 2

		int result2 = binarySearch(inputArray1, 6);
		System.out.println("result2: " + result2); // expect -1

		int[] inputArray2 = { 1, 2, 2, 2, 3, 4 };
		int result3 = binarySearch(inputArray2, 2);
		System.out.println("result3: " + result3); // expect 1 or 2 or 3

		// test(s) for searchInMatrix()
		int[][] inputMatrix1 = { { 1, 2, 3 }, { 5, 7, 11 }, { 13, 17, 19 } };
		int[] resultMatrix1 = searchInMatrix(inputMatrix1, 11);
		System.out.println("resultMatrix1: " + resultMatrix1[0] + ", " + resultMatrix1[1]);
		// test(s) for closest()
		int[] inputClosest1 = { 1, 2, 4, 8, 16 };
		int resultClosest1 = closest(inputClosest1, 7);
		System.out.println("resultClosest1: " + resultClosest1); // expect 3
		int[] inputClosest2 = { 1, 3, 3, 4 };
		int resultClosest2 = closest(inputClosest2, 2);
		System.out.println("resultClosest2: " + resultClosest2); // expect 0 or 1 or 2
		int[] inputClosest3 = { 1, 4, 6 };
		int resultClosest3 = closest(inputClosest3, 5);
		System.out.println("resultClosest3: " + resultClosest3); // expect 1 or 2

		// test(s) for firstOccur()
		int resultFirstOccur = firstOccur(inputArray2, 2);
		System.out.println("resultFirstOccur: " + resultFirstOccur); // expect 1

	}

	// Practice #1 Classical Binary Search
	/**
	 * Search for the index of a specific value in a sorted array; return -1 if an
	 * error occur; O(log n); always pick the middle index of the possible ranges;
	 * 
	 * @param array  the sorted array
	 * @param target the target value
	 * @return a possible index that outputs the exact value, -1 if an error occured
	 */
	public static int binarySearch(int[] array, int target) {
		if (array == null || array.length == 0) { // if the array is null or empty, return -1
			return -1;
		}
		int mid = (array.length - 1) / 2;
		int low = 0;
		int high = array.length - 1;
		while (array[mid] != target) {
			if (array[mid] < target) { // if the guessing index gives a value less than the target value
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			if (low > high) { // if no index is found
				return -1;
			}
			mid = low + (high - low) / 2;
		}
		return mid;
	}

	// Practice #2 Classical Binary Search in 2D Space
	/**
	 * Search for the index of a specific value in a sorted 2D matrix; return -1 if
	 * an error occur; O(log n); same logic as the binary search
	 * 
	 * @param matrix the sorted 2D matrix
	 * @param target the target value
	 * @return a possible index pair that outputs the exact value, {-1, -1} if an
	 *         error occured
	 */
	public static int[] searchInMatrix(int[][] matrix, int target) {
		int[] err = { -1, -1 };
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return err;
		} // if the matrix is null or empty, return -1
		int mid = (matrix.length * matrix[0].length - 1) / 2;
		int low = 0;
		int high = matrix.length * matrix[0].length - 1;
		int row = mid / matrix[0].length;
		int col = mid % matrix[0].length;
		while (matrix[row][col] != target) { // treating the matrix as an sorted array
			if (matrix[row][col] < target) { // if the guessing index pair gives a value less than the target value
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			if (low > high) { // if no index pair is found
				return err;
			}
			mid = low + (high - low) / 2;
			row = mid / matrix[0].length;
			col = mid % matrix[0].length;
		}
		int[] result = new int[2];
		result[0] = row;
		result[1] = col;
		return result;
	}

	// Practice #3 Closest In Sorted Array
	/**
	 * Search for the index of a specific value in a sorted array return -1 if an
	 * error occur; O(log n); same logic as the binary search to give a possible
	 * index
	 * 
	 * @param array  the sorted array
	 * @param target the target value
	 * @return a possible index that outputs the closest value, -1 if an error
	 *         occured
	 */
	public static int closest(int[] array, int target) {
		if (array == null || array.length == 0) { // if the array is null or empty, return -1
			return -1;
		}
		int mid = (array.length - 1) / 2;
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			if (array[mid] < target) { // if the guessing index gives a value less than the target value
				low = mid + 1;
			} else if (array[mid] > target) {
				high = mid - 1;
			} else {
				return mid;
			}
			mid = low + (high - low) / 2;
		}

		// if no index is found
		int betweener; // the other index that might be close to the target
		if (array[mid] < target) { // if the index is less than the potential correct index
			betweener = mid + 1;
			if (betweener > array.length - 1) { // check out of bound
				return mid;
			}
		} else {
			betweener = mid - 1;
			if (betweener < 0) { // check out of bound
				return mid;
			}
		}
		return (Math.abs(array[mid] - target) > Math.abs(array[betweener] - target)) ? mid : betweener;
	}

	// Practice #4 First Occurrence
	/**
	 * Search for the index of a specific value in a sorted array return -1 if an
	 * error occur; O(log n)
	 * 
	 * @param array  the sorted array
	 * @param target the target value
	 * @return the first possible index that outputs the exact value, -1 if an error
	 *         occured
	 */
	public static int firstOccur(int[] array, int target) {
		if (array == null || array.length == 0) { // if the array is null or empty, return -1
			return -1;
		}
		int mid = (array.length - 1) / 2;
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			if (array[mid] < target) { // if the guessing index gives a value less than the target value
				low = mid + 1;
			} else if (array[mid] > target) {
				high = mid - 1;
			} else if (low != mid) {
				high = mid;
			} else {
				return mid;
			}
			mid = low + (high - low) / 2;
		}
		return -1; // Error
	}

}
